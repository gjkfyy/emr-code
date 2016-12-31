/*
 * 本地化类
 */
Ext.define('Xap.ej.locale.Locale', {
	locale: null,
	
	constructor: function() {
		if (window.locale) {
			this.locale = window.locale;
			try {
				//ie下删除会有问题，故而加入到try-catch
				delete window.locale;
			} catch (e) {
				
			}
		}
	},
	
	get: function(subClass, key, values) {
		var result = '';
		if (this.locale && this.locale[subClass]) {
			//从文件获得
			var subClass = this.locale[subClass];
			result = subClass[key] || '';
		} else {
			var i18n = 'i18n_' + (navigator.language || navigator.systemLanguage);
			if (window.iemr && window.iemr.extensions && window.iemr.extensions[i18n]) {
				//从扩展点获得
				i18n = window.iemr.extensions[i18n];
				for (var i = 0; i < i18n.length; i++) {
					var lang = i18n[i];
					if (lang[subClass]) {
						result = (lang[subClass])[key] || '';
						break;
					}
				}
			}
		}
		if (Ext.isFunction(result)) {
			result = result.call(null, values);
		} else if (values) {
			result = result.replace(/\{(\d+)\}/g, function(m, i) {
	            return values[i];
	        });
		}
		
		return result;
	}
}, function() {
	window.XapLocale = Ext.create('Xap.ej.locale.Locale');
});