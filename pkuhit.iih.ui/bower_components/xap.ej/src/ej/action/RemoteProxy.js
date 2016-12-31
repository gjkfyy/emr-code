Ext.define('Xap.ej.action.RemoteProxy', {
    extend: 'Ext.data.proxy.Rest',

    alias: 'proxy.xapremoteproxy',

    reader: {
        type: 'json'
        // root: 'data'
    },

    writer: {
        type: 'json'
    },

    listeners: {
        exception: function(proxy, response, operation) {
            if (response.status == 404) {
                // FuiMessageBox.fail(FuiLocale.get('connect', 'connectFailure'));
				Xap.debug('404');
            } else if (response.status == 500) {
                Xap.debug('500');
            } else {
				Xap.debug('unknown');
            }
        }
    }
});