/**
 *
 */
package org.scrutmydocs.webapp.servlet;

import fr.pilato.elasticsearch.river.fs.util.FsRiverUtil;
import org.apache.lucene.util.IOUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.bytes.BytesArray;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Download Document Servlet
 *
 * @author laborie
 */
public class DownloadServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3093542409787735469L;

	/** The spring context. */
	private ApplicationContext springContext;

	/** The ES client. */
	private Client client;

    private ESLogger logger = Loggers.getLogger(getClass().getName());

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Retrieve the SearchService
		this.springContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String index = req.getParameter("index");
//        String contentType = req.getParameter("content_type");
		Client client = this.getClient();

		GetResponse responseEs = client.prepareGet()
                .setIndex(index).setId(id)
                .setFields(
//                        "content",
                        "file.filename",
                        "file.content_type",
                        "path.real")
                .execute().actionGet();

        if(responseEs.isExists()) {
			// Write into stream...
			ServletOutputStream out = resp.getOutputStream();
                String contentType = (String) responseEs.getField("file.content_type").getValue();
				String name = (String) responseEs.getField("file.filename").getValue();
                String path = (String) responseEs.getField("path.real").getValue();
//            String path = "file:///Users/hinkman/haha/dtrace_dbw3.out";
                if (logger.isDebugEnabled())
                    logger.debug("download('{}', '{}', '{}','{}','{}')", id, index, contentType, name, path);
//				String content = (String) responseEs.getField("content").getValue();
//                byte[] encoded = Files.readAllBytes((Path) responseEs.getField("file.path.real").getValue());
//                String content = new String(Files.readAllBytes(path));
            String content = new String(Files.readAllBytes(Paths.get(path)));

            try {
				resp.setHeader("Content-type", contentType);
//				resp.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
				out.write(content.getBytes());
			} finally {
                if (logger.isDebugEnabled())
                    logger.debug("download('exception')");
                IOUtils.closeWhileHandlingException(out);
			}
		} else {
			resp.sendError(HttpServletResponse.SC_NO_CONTENT);
		}
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	private synchronized Client getClient() {
		if(this.client == null) {
			this.client = this.springContext.getBean(Client.class);
		}
		return this.client;
	}
}
