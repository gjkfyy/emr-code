Ext.define('Xap.ej.action.ActionFactory', {
    singleton: true,
	/*
	* @param Action类型
	* @return Action对象
	*/
    createAction:function(config){
        return Xap.create(config);
    },
	
	createChain: function(config) {
        config.xclass = 'Xap.ej.action.Chain';
        return Xap.create(config);
	}
});