Ext.define('Xap.ej.Net', {
	singleton: true,
	
	mixins: {
		observable: 'Ext.util.Observable'
	},

	constructor: function (config) {
		this.mixins.observable.constructor.call(this, config);
		this.addEvents(
			'data'
		);
	},

	open: function(config) {
		var me = this;
		var port = 8890;
		if(config && config.port) {
			port = config.port;
		}
		var netMgr = this.netMgr;
		if(!netMgr) {
			throw 'do not support native net function';
		}
		netMgr.open({
			port: port
		});
		netMgr.on('connection', function(conn) {
			conn.on('data', function(data) {
				me.fireEvent('data', conn, data);
			});
		});
	}
});