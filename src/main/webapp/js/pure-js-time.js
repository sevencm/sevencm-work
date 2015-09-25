/**
 * function TimeTo(elementId)
 * 
 * <p>
 * 倒计时
 * </p>
 * 
 * @param {String} endTime
 * 
 */ 
function TimeTo(endTime){
    var t = new Date(dd),//取得指定时间的总毫秒数
        n = new Date().getTime(),//取得当前毫秒数
        c = t - n;//得到时间差
    if(c<=0){//如果差小于等于0  也就是过期或者正好过期，则退出程序
        clearInterval(window['ttt']);//清除计时器
        return;//结束执行
    }
    var ds = 60*60*24*1000,//一天共多少毫秒
        d = parseInt(c/ds),//总毫秒除以一天的毫秒 得到相差的天数
        h = parseInt((c-d*ds)/(3600*1000)),//然后取完天数之后的余下的毫秒数再除以每小时的毫秒数得到小时
        m = parseInt((c - d*ds - h*3600*1000)/(60*1000)),//减去天数和小时数的毫秒数剩下的毫秒，再除以每分钟的毫秒数，得到分钟数
        s = parseInt((c-d*ds-h*3600*1000-m*60*1000)/1000);//得到最后剩下的毫秒数除以1000 就是秒数，再剩下的毫秒自动忽略即可
		document.getElementById('timer').innerHTML = '<p> <b>'
					+ d
					+ '</b> 天 <b>'
					+ h
					+ '</b> 小时 <b>'
					+ m
					+ '</b> 分<b>'
					+ s 
					+ '</b> 秒</p>';
}