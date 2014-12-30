var initIndexes = function() {
// Initialize the jQuery File Upload widget:

    if (config.useIndexes == true) {
        $("#noindexlistquery").hide();

        // Fetch index list
        $.getJSON("http://" + config.elasNode + ":9200/_mapping/" + config.onlyIndexesWithTypes.toString(),function(json) {
//            // Handle errors
//            if (!json.ok) {
//                showRestError(json);
//                return;
//            }
//            showRestError('test');
            // Update indexes Menu
            $.each(json, function(index,docindex) {
//                console.log(index+'   '+docindex);
//                $('<li id="river-fs-'+fsriver.id+'"><a href="#"><i class="icon-folder-open"></i> '+fsriver.name+status+'</a></li>')
//                    .insertAfter("#rivers-fs")
                $('<option id="index-'+index+'" value="'+index+'">'+index+'</option>').insertAfter("#index-today")
            });
        });

        $.each(config.onlyIndexesWithTypes, function(index) {
            $('<option id="type-'+config.onlyIndexesWithTypes[index]+'" value="'+config.onlyIndexesWithTypes[index]+'">'
                +config.onlyIndexesWithTypes[index]+'</option>').insertBefore("#type-all")
        });
        $("#type-all").remove();

    } else {
        $("#indexlistselect").hide();
        $("#typelistselect").hide();
        $("#indexlistquery").hide();
    }
}
