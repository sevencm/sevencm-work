var $ = {
	getJSON : function(url, params, callbackFuncName, callback) {
		var paramsUrl = "", jsonp = this.getQueryString(url)[callbackFuncName];
		for ( var key in params) {
			paramsUrl += "&" + key + "=" + encodeURIComponent(params[key]);
		}
		url += paramsUrl;
		window[jsonp] = function(data) {
			window[jsonp] = undefined;
			try {
				delete window[jsonp];
			} catch (e) {
			}
			if (head) {
				head.removeChild(script);
			}
			callback(data);
		};

		var head = document.getElementsByTagName('head')[0];
		var script = document.createElement('script');
		script.charset = "UTF-8";
		script.src = url;
		head.appendChild(script);
		return true;
	},
	getQueryString : function(url) {
		var result = {}, queryString = (url && url.indexOf("?") != -1 && url
				.split("?")[1])
				|| location.search.substring(1), re = /([^&=]+)=([^&]*)/g, m;
		while (m = re.exec(queryString)) {
			result[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
		}
		return result;
	}
};

$.getJSON("http://api.map.baidu.com/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=tPoyQZNtl6xVPWd0Zjvez2zr&callback=showLocation",
		{
		}, "showLocation", function(data) {
			console.log(data);
		});

function showLocation(data){
	console.log(data);
}