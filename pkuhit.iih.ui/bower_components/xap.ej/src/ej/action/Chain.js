Ext.define('Xap.ej.action.Chain', {
    requires: [
        'Xap.ej.action.Phase',
        'Xap.ej.action.LocalChainExecutor'
    ],

    inheritableStatics: {
        setExecutor: function(executor) {
            this.executor = this.prototype.executor = executor;
            return executor;
        },

        getExecutor: function() {
            var executor = this.executor;
            if(!executor) {
                executor = this.prototype.executor;
            }
            // TODO 默认Executor
            /*
            if(!executor) {
                this.executor = this.setExecutor(Xap.create({
                    xclass: 'Xap.ej.action.LocalChainExecutor'
                }));
            }*/
            return executor;
        }
    },

    constructor: function() {
        this.callParent(arguments);
        this.phases = {},
        // 初始化
        this.createPhase('default');
    },

    findExecutor: function() {
        var clazz = Xap.ej.action.Chain;
        return clazz.getExecutor();
    },

    /*
    * 追加Action
    * @param obj 单个Action或者带有阶段信息的对象
    */
    addAction: function(obj) {
        if(!obj) {
            return;
        }
        var phase = null;
        var action = null;
        // 是单个Action对象
        if(!obj.phase) {
            phase = this.getPhase('default');
            action = obj;
        }
        else {
            phase = obj.phase();
            action = obj.action();
        }
        phase.addAction(action);
    },

    /*
    * 追加Chain
    * @param obj 单个Chain或者带有阶段信息的对象
    */
    /*addChain: function(obj) {
        if(!obj) {
            return;
        }
        var phase = null;
        var chain = null;
        // 是单个Action对象
        if(!obj.phase) {
            phase = getPhase('default');
            chain = obj;
        }
        else {
            phase = obj.phase();
            chain = obj.chain();
        }
        phase.addChain(phase.getSize(), chain);
    },*/

    setChain: function(i, obj) {
        if(!obj || i < 0) {
            return;
        }
        var phase = null;
        var chain = null;
        // 是单个Action对象
        if(!obj.getPhase) {
            phase = getPhase('default');
            chain = obj;
        }
        else {
            phase = obj.getPhase();
            chain = obj.getChain();
        }
        phase.insertChain(i, action);
    },

    /*
    * 覆盖Action
    * @param obj 单个Action、Action链条或者带有阶段信息的对象
    * 如果没有阶段信息，则认为需要添加到default阶段
    */
    setAction: function(i, obj) {
    },

    getPhase: function(pn) {
        // 无效的参数，直接返回
        if(!pn || pn.length <= 0) {
            return null;
        }

        if(!this.phases) {
            this.phases = {};
        }
        if(!this.phases[pn]) {
            createPhase(pn);
        }
        return this.phases[pn];
    },

    getPhases: function() {
        return this.phases;
    },

    createPhase: function(pn) {
        if(Ext.isString(pn) && !Ext.isEmpty(pn)) {
            this.phases[pn] = Xap.create({
                xclass: 'Xap.ej.action.Phase',
                name: pn
            });
        }
    },

    execute: function(context) {
        var executor = this.findExecutor();
        executor.execute(this, context);
        /*for(var pn in this.phases) {
            var phase = this.phases[pn];
            phase.execute(context);
        }*/
    },

    getActionByClass: function(cls) {
        if(!cls) {
            return null;
        }
        var phase = this.getPhase('default');
        var actions = phase.getActions();
        for(var i = 0; i < actions.length; i++) {
            var action = actions[i];
            var r = null;
            if(action instanceof Xap.ej.action.Chain) {
                r = action.getActionByClass(cls);
            }
            else {
                var cn = Ext.getClassName(action);
                if(cn == cls) {
                    r = action;
                }
            }
            if(r) {
                return r;
            }
        }
        return null;
    }
});