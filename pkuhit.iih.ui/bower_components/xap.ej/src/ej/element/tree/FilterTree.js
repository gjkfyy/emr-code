/** 
 *
 * @extends Ext.tree.Panel
 * @author ：wangyanli
 * 
 */
Ext.define('Xap.ej.element.tree.FilterTree', {
    extend: 'Xap.ej.element.tree.Tree',
    alias: 'widget.filtertree',
	leafNodes : [] ,
    filterByText: function(text) {
        this.filterBy(text, 'text');
    },
    /**
     * Filter the tree on a string, hiding all nodes expect those which match and their parents.
     * @param The term to filter on.
     * @param The field to filter on (i.e. 'text').
     */
    filterBy: function(text, by) {
        this.clearFilter();
        var view = this.getView(),
            me = this,
            nodesAndParents = [];
			
        // Find the nodes which match the search term, expand them.
        // Then add them and their parents to nodesAndParents.
        if(null != text && text.toString() != ''){
        	this.getRootNode().cascadeBy(function(tree, view){
                var currNode = this;
                if(currNode && (null != currNode.data[by] && 'undefined' != currNode.data[by]) && currNode.data[by].toString().toLowerCase().indexOf(text.toString().toLowerCase()) > -1) {
                    //me.expandPath(currNode.getPath());
                    while(currNode.parentNode) {
    					currNode.expand();
    					if(currNode.data.leaf){
    						me.leafNodes.push(currNode);
    				    };
                        nodesAndParents.push(currNode.id);
                        currNode = currNode.parentNode;
                    }
                }
            }, null, [me, view]);
            // Hide all of the nodes which aren't in nodesAndParents
            this.getRootNode().cascadeBy(function(tree, view){
                var uiNode = view.getNodeByRecord(this);
                if(uiNode && !Ext.Array.contains(nodesAndParents, this.id)) {
                    Ext.get(uiNode).setDisplayed('none');
                }
            }, null, [me, view]);
        }
        
    },
    clearFilter: function() {
		this.leafNodes.length=0;
        var view = this.getView();
        this.getRootNode().cascadeBy(function(tree, view){
            var uiNode = view.getNodeByRecord(this);
            if(uiNode) {
                Ext.get(uiNode).setDisplayed('table-row');
            }
        }, null, [this, view]);
    }
});