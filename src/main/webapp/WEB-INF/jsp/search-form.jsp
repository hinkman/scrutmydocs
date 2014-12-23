<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div id="intro" class="well">
    <%-- Hero unit header --%>
    <%--<div id="intro-1" class="row">--%>
        <%--<div class="span10 offset1 center">--%>
            <%--<a href="index.jsp"><img src="img/logo-text.png" alt="Logo"/></a>--%>
        <%--</div>--%>
    <%--</div>--%>
    <div id="intro-2"  class="row">
        <div class="span2 invisible">
            <%--<a href="index.jsp"><img id="logo-small" src="img/logo.png" alt="Logo"/></a>--%>
            &nbsp;
        </div>
        <div class="span6">
            <form class="form form-search" style="margin: 0 0 5px;">
                <div class="input-append">
                    <select id="indexlistselect" name="ils" class="search-query span2">
                        <option id="index-today" selected>Today</option>
                    </select>
                    <input id="indexlistquery" name="q" type="text" class="span5">
                    <input id="noindexlistquery" name="q" type="text" class="search-query span7">
                    <button type="submit" class="btn btn-primary"><i class="icon-white icon-search"></i></button>
                    <%--<div id="loading"><img src="img/loading.gif"/></div>--%>
                </div>
            </form>
        </div>
    </div>
</div>