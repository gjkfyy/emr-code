Ext.define('Xap.ej.config.Configable', {
    requires: 'Xap.ej.block.PropertyBlock',
    
    doCheckXapConfig: Ext.emptyFn,

    doXapConfig: function() {
        var config = this.doXapConfigMerge();
        this.doBlockConfig(config);
        this.doActionConfig(config);
        this.doChainConfig(config);
        this.doConnectionConfig(config);
    },

    doXapConfigMerge: function() {
        var config = Ext.clone(this.xapConfig);
        // 合并默认的配置
        if(this.defaultXapConfig) {
            var dc = Ext.clone(this.defaultXapConfig);
            config = Ext.merge(dc, config);
        }
        return config;
    },

    doBlockConfig: function(config) {
        var blockConfig = config.blocks;
        for(var bn in blockConfig) {
            var bc = blockConfig[bn];
            bc.xapId = bn;
            var block = Xap.create(bc);
            this.add(block);
            this.addBlock(bn, block);
        }
        // 添加一个默认的properties块
        var pb = this.getBlock('properties');
        if(!pb) {
            pb = Xap.create({
                xclass: 'Xap.ej.block.PropertyBlock'
            })
            this.addBlock('properties', pb);
        }
    },

    doActionConfig: function(config) {
        var af = Xap.ej.action.ActionFactory;
        var actionConfig = config.actions;
        for(var an in actionConfig) {
            var ac = actionConfig[an];
            // TODO 添加新属性都要修改这里，稍显繁琐，需要更好的方式
            // TODO action配置里的blocks属性怎么办？目前直接加到Ext.create里去了，有点儿风险
            var action = af.createAction(ac);
            action.owner = this;
            /*
            var action = af.createAction({
                xclass: ac.xclass,
                url: ac.url
            });
            */
            this.doActionBlockConfig(action, ac);
            // TODO
            this.addAction(an, action);
        }
    },

    doActionBlockConfig: function(action, actionConfig) {
        var blocks = actionConfig.blocks;
        for(var k in blocks) {
            var b = this.getBlock(blocks[k]);
            if(!b)
                continue;
            action.addBlock(k, b);
        }
    },

    doChainConfig: function(config) {
        var af = Xap.ej.action.ActionFactory;
        var chainConfig = config.chains;
        for(var cn in chainConfig) {
            var cc = chainConfig[cn];
            // 根据名称创建Chain
            var chain = af.createChain({
                name: cn
            });

            for(var i = 0; i < cc.length; i++) {
                var action = this.getAction(cc[i]);
                chain.addAction(action);
            }
            this.addActionChain(cn, chain);
        }
    },

    doConnectionConfig: function(config) {
        var connectionConfig = config.connections;
        for(var bn in connectionConfig) {
            var block = this.getBlock(bn);
            var cc = connectionConfig[bn];
            for(var i = 0; i < cc.length; i++) {
                var c = cc[i];
                var chain = this.getActionChain(c.chain);
                if(c.selector) {
                    block.connect(c.selector, c.event, chain);
                    /*
                    block.on('afterrender', function() {
                        block.connect(c.selector, c.event, chain);
                    }
                  );*/
                }
                else {
                    block.connect(c.event, chain);
                }
            }
        }
    },

    addAction: function(name, action) {
        if (Ext.isString(name)) {
            this.actions[name] = action;
        }
    },

    getAction: function(name) {
        return this.actions[name];
    },
    
	addActionChain : function(name, chain) {
		if (Ext.isString(name)) {
			this.chains[name] = chain;
		}
	},

	/*
	 * 返回当前Block关联的Action @param action的名字
	 */
	getActionChain : function(name) {
		return this.chains[name];
	},

    getBlock: function(name) {
        return this.blocks[name];
    },

    addBlock: function(name, block) {
        if(name && block) {
            this.blocks[name] = block;
        }
    }
});
