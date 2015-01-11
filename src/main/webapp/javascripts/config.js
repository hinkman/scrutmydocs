var config = {

    // Master on/off switch - must be true for any
    // index-related changes. Setting to true will
    // result in index drop-down on main page
    // Default: false
    useIndexes: true,
    elasNode: '172.28.25.157',

    // This controls the scope of searches - more
    // accurately, the existence of the 'All' option
    // in the index drop-down.
    // Default: false
    useOnlyOneIndex: true,

    // Default is to list all indexes in the drop-
    // down. This being set to any list will filter
    // to only indexes with these *types* of docs
    // in them.
    // Default: []
    onlyIndexesWithTypes: ['hub','gis','cyc'],

    // Display order for drop-down list. Possible
    // values are 'alphabetic' or 'creation_date'.
    // Default: 'alphabetic'
    indexOrder: 'alphabetic'

};

