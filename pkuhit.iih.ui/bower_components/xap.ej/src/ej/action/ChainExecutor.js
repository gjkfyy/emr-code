Ext.define('Xap.ej.action.ChainExecutor', {
    requires: ['Xap.ej.action.Phase'],

    constructor: function() {
        this.callParent(arguments);
    },

    execute: function(chain, context) {
		this.setChain(chain);
        // TODO 支持链的“阶段”
        var phase = chain.getPhase('default');
        var executions = {
            flow: [],
            close: false,
            success: null,
            fail: null
        };
        this.prepareExecutionsByPhase(phase, executions);
        this.doExecute(executions.flow, context);
    },

    // 用于继承
    doExecute: Ext.emptyFn,

    prepareExecutionsByPhase: function(phase, executions) {
        var actions = phase.getActions();
        for(var i = 0; i < actions.length; i++) {
            var action = actions[i];
            if(action instanceof Xap.ej.action.Chain) {
                this.prepareExecutionsByChain(action, executions);
            }
            else if(action instanceof Xap.ej.action.Action) {
                this.prepareExecutionsByAction(action, executions);
            }
        }
    },

    prepareExecutionsByChain: function(chain, executions) {
        // TODO 目前只支持default阶段
        var phase = chain.getPhase('default');
        this.prepareExecutionsByPhase(phase, executions);
    },

    prepareExecutionsByAction: function(action, executions) {
        executions.flow.push(action);
    },

    doOperationCallback: function(operation) {
        if(operation.success && Ext.isFunction(operation.success)) {
            operation.success.call(operation.scope, operation);
        }
    },
	
	setChain: function(chain) {
		this.chain = chain;
	},
	
	getChain: function() {
		return this.chain;
	}
    // TODO doAction
});