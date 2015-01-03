var initIndexes = function() {
// Index list:

    if (config.useIndexes == true) {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();

        if(dd<10) {
            dd='0'+dd
        }

        if(mm<10) {
            mm='0'+mm
        }

        $("#noindexlistquery").hide();
        $("#index-today").replaceWith('<option id="index-today" value="' + yyyy + '-' + mm + '-' + dd + '" selected>Today</option>');

        // Fetch index list
        $.getJSON("http://" + config.elasNode + ":9200/_mapping/" + config.onlyIndexesWithTypes.toString(),function(json) {
//            // Handle errors
//            if (!json.ok) {
//                showRestError(json);
//                return;
//            }
//            showRestError('test');
            // Update indexes Menu
            var index_list = Object.keys(json).sort();
//            console.log(index_list);
            $.each(index_list, function(key,index) {
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
