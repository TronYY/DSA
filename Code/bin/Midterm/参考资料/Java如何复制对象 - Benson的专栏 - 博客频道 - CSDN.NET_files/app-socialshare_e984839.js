clouda.define("mbaas/app",function(){function o(){return clouda.RUNTIME===clouda.RUNTIMES.KUANG&&clouda.PLATFORM===clouda.PLATFORMS.IOS&&"function"==typeof BLightApp.addLAPush?!0:!1}function u(o,u,a){var c={appid:a.appid,statis_ext:{src:"clouda"},push_action:u};a.nonce&&(c.nonce=a.nonce),a.csrftoken&&(c.csrftoken=a.csrftoken),a.tag&&(c.tags=[a.tag]);var i={push_params:c},s=function(){a.onsuccess(1)},t=function(o){a.onfail(o)};return n(o,JSON.stringify(i),s,t),!1}var a=clouda.lightapp,c=clouda.mbaas.app={},n=(clouda.mbaas||{},clouda.DelegateClass,clouda.kuangForReady,clouda.runtimeError,clouda.installPlugin,clouda.cloudaBLight),i=clouda.ErrCode,s=clouda.lib.utils.stat;c.followSite=function(c,t){if(s({api:"app.followSite"}),c){if(clouda.lib.utils.setLogStorage("app","followSite"),clouda.PLATFORM===clouda.PLATFORMS.IOS){if(o())return t.appid=c,void u("addLAPush","subscribe",t);if(navigator.userAgent.match(/baiduboxapp\/([\d.-_]*)/i)&&clouda.RUNTIME!==clouda.RUNTIMES.KUANG){if(clouda.RUNTIME_VERSION<"6.1")return t.onsuccess&&"function"==typeof t.onsuccess&&t.onsuccess(0),void clouda.lib.moplus.openApp(!1,c,{tip:"请使用最新版【手机百度】\n订阅",startDownload:1,platform:"ios"});if(clouda.RUNTIME_VERSION>="6.1")return void clouda.lib.moplus.openApp(!0,c)}else if(clouda.RUNTIME===clouda.RUNTIMES.KUANG)return t.onsuccess&&"function"==typeof t.onsuccess&&t.onsuccess(0),void clouda.lib.moplus.openApp(!1,c,{tip:"请使用最新版【手机百度】\n订阅",startDownload:1,platform:"ios"})}if(clouda.RUNTIME===clouda.RUNTIMES.KUANG)return clouda.RUNTIME_VERSION<"5.3"?(t.onsuccess&&"function"==typeof t.onsuccess&&t.onsuccess(0),void clouda.lib.moplus.openApp(!1,c,{tip:"请使用最新版【手机百度】\n订阅",startDownload:1})):(n("followSite",function(){t.onsuccess(clouda.STATUS.SUCCESS)},t.onfail),!1);if("undefined"!=typeof BLightApp||navigator.userAgent.match(/baiduboxapp\/([\d.-_]*)/i))return clouda.RUNTIME_VERSION>="5.3"?void clouda.lib.moplus.openApp(!0,c):(t.onsuccess&&"function"==typeof t.onsuccess&&t.onsuccess(0),void clouda.lib.moplus.openApp(!1,c,{tip:"请使用最新版【手机百度】\n订阅",startDownload:1}));if(clouda.RUNTIME===clouda.RUNTIMES.LIGHTSDK){var e={appid:c||clouda.lightapp.appid,channel:t.src||"clouda",addShortcut:!1};return void clouda.lightsdk(t.onsuccess,t.onfail,"device.push","followSite",e)}if("undefined"!=typeof uix_bridge){var e={appid:c},l=clouda.lib.utils.regcallback(t.onsuccess,t.onfail);return void uix_bridge.followSite(JSON.stringify(e),l.s,l.f)}clouda.RUNTIME===clouda.RUNTIMES.NUWA&&clouda.NUWA_VERSION>="2.6"&&(nuwa&&nuwa.am&&"function"==typeof nuwa.am.subscribe?nuwa.am.subscribe(c,function(){t.onsuccess(clouda.STATUS.SUCCESS)},function(o){a.error(i.APP_ERROR,o,t)}):document.addEventListener("runtimeready",function(){nuwa.am.subscribe(c,function(){t.onsuccess(clouda.STATUS.SUCCESS)},function(o){a.error(i.APP_ERROR,o,t)})}))}},c.checkFollow=function(o,u){return o?(clouda.lib.utils.setLogStorage("app","checkFollow"),clouda.RUNTIME===clouda.RUNTIMES.KUANG?(n("queryWzStatus",function(o){u.onsuccess(parseInt(o.status,10))},u.onfail),!1):void(clouda.RUNTIME===clouda.RUNTIMES.NUWA&&(nuwa&&nuwa.am&&"function"==typeof nuwa.am.hasSubscribed?nuwa.am.hasSubscribed(o,function(o){u.onsuccess(o?1:0)},function(o){a.error(i.APP_ERROR,o,u)}):document.addEventListener("runtimeready",function(){nuwa.am.hasSubscribed(o,function(o){u.onsuccess(o?1:0)},function(o){a.error(i.APP_ERROR,o,u)})})))):void a.error(i.UNKNOW_INPUT,i.UNKNOW_INPUT,u)},c.checkSupport=function(o){var u={};clouda.RUNTIME===clouda.RUNTIMES.NUWA?u["native"]=1:clouda.RUNTIME===clouda.RUNTIMES.KUANG?u["native"]=BLightApp&&"function"==typeof BLightApp.followSite?1:0:clouda.RUNTIME===clouda.RUNTIMES.WEB&&(u["native"]=0),u.web=0,o(u)}});
;clouda.define("mbaas/socialshare",function(){function e(e){var a=clouda.lightInit.ak||clouda.lightapp.ak,t=document.getElementsByClassName("bdSharePopup");if(1==e.hide){for(var c,d=0,u=t.length;u>d;d++)c=t[d],"block"==c.style.display&&(c.style.display="none");return!1}var s=function(e){var i=e.parentNode;i&&i.removeChild(e)};if(!e.content)return!1;for(var p=t.length,m=p-1;m>=0;m--)t[m]&&s(t[m]);e.linkUrl=e.linkUrl?e.linkUrl:location.href,e.linkUrl=n(e.linkUrl),console.log(e.linkUrl),e.linkUrl=encodeURIComponent(e.linkUrl),e.imageUrl=e.imageUrl?encodeURIComponent(e.imageUrl):"";var f={afterRender:function(){console.log("afterRender exec...")},client_id:a,dom_id:"hidden_btn",content:e.content,theme:"native",appid:e.appid?e.appid:"",animate:!1,url:e.linkUrl,pic_url:e.imageUrl};if(console.log(f),document.querySelector("#hidden_btn"))return l=document.getElementById("hidden_btn"),void socShare.init(f,function(){l.dispatchEvent(o)});var h;h="http:"===window.location.protocol?"http://apps.bdimg.com":"https://openapi.baidu.com";var U=2;i(h+"/cloudaapi/socialshare-api/share.min.js?a="+U,function(){var i=["weixin_friend","weixin_timeline","qqfriend","sinaweibo","qqweibo","qqdenglu","renren","sms","email"];if(e.mediaType&&"all"!==e.mediaType){for(var n=!1,t=0,c=i.length;c>t;t++)if(i[t]==e.mediaType){n=!0;break}if(n)return void("weixin_friend"==e.mediaType||"weixin_timeline"==e.mediaType||"qqfriend"==e.mediaType?clouda.lib.moplus.openApp(!0,f.appid):"sinaweibo"==e.mediaType||"qqweibo"==e.mediaType||"renren"==e.mediaType?location.href="http://openapi.baidu.com/social/widget/share?method=share&media_type="+e.mediaType+"&client_id="+a+"&url="+e.linkUrl+"&pic_url="+e.imageUrl+"&content="+encodeURIComponent(e.content)+"&u="+e.linkUrl:"qqdenglu"==e.mediaType?location.href=socShare.acc.getQQHref(f):("sms"==e.mediaType||"email"==e.mediaType)&&socShare.acc.getShortLink({client_id:a,url:e.linkUrl},function(){var i=socShare.acc.shortLinks[e.mediaType];location.href="sms"==e.mediaType?socShare.acc.getSMSHref(e.content,i):socShare.acc.getEmailHref(e.content,i)}))}r=!0,document.querySelector("#hidden_btn")?console.log("js 加载失败"):(l=document.createElement("div"),l.id="hidden_btn",l.style.display="none",document.body.appendChild(l),socShare.init(f,function(){l.dispatchEvent(o)}))})}function i(e,i){var n,a,t,l=document.head||document.getElementsByTagName("head")[0]||document.documentElement;"object"==typeof e&&(a=e,e=void 0),t=a||{},e=e||t.url,i=i||t.success,n=document.createElement("script"),n.id="share_script",n.async=t.async||!1,n.type="text/javascript",n.charset=t.charset?t.charset:"utf-8",n.src=e,l.insertBefore(n,l.firstChild),"function"==typeof i&&(document.addEventListener?n.addEventListener("load",i,!1):n.onreadystatechange=function(){/loaded|complete/.test(n.readyState)&&(n.onreadystatechange=null,i())})}function n(e){var i=e,n=e.match(/^(http:\/\/|https:\/\/)?(.+\?)/i);if(n){for(var a=e.substring(n[0].length),t=a.split("&"),l=[],o=0;o<t.length;o++)t[o].match(/^bd_/)||l.push(t[o]);i=n[0]+l.join("&")}return i}{var a=(clouda.mbaas||{},clouda.lightapp),t=clouda.mbaas.socialshare={};clouda.DelegateClass,clouda.kuangForReady,clouda.runtimeError,clouda.installPlugin,clouda.cloudaBLight}t.loadFlag=1;var l=null,o=document.createEvent("HTMLEvents");o.initEvent("click",!1,!1),o.eventType="message";var r=!1;return t.callShare=function(i){if(clouda.lib.utils.stat({api:"socialshare.callShare"}),clouda.RUNTIME===clouda.RUNTIMES.KUANG&&BLightApp&&"function"==typeof BLightApp.callShare||navigator.userAgent.match(/baiduboxapp\/([\d+.]+)/)&&clouda.RUNTIME_VERSION>="5.3.5"){if(1==i.hide)return!1;if(!i.onsuccess||!i.onfail||"function"!=typeof i.onsuccess||"function"!=typeof i.onfail)return a.error(ErrCode.UNKNOW_INPUT,ErrCode.UNKNOW_INPUT,i),!1;if(!i.content)return a.error(ErrCode.UNKNOW_INPUT,ErrCode.UNKNOW_INPUT,i),!1;if(!i.mediaType)return a.error(ErrCode.UNKNOW_INPUT,ErrCode.UNKNOW_INPUT,i),!1;i.title||(i.title="来自手机百度"),i.linkUrl||(i.linkUrl=location.href),i.linkUrl=n(i.linkUrl);var t=clouda.lib.utils.regcallback(i.onsuccess,i.onfail);if(clouda.RUNTIME===clouda.RUNTIMES.KUANG)BLightApp.callShare(JSON.stringify(i),t.s,t.f);else if("undefined"!=typeof Bdbox_android_utils&&"undefined"!=typeof Bdbox_android_utils.callShare)Bdbox_android_utils.callShare(JSON.stringify(i),t.s,t.f);else if(clouda.PLATFORM===clouda.PLATFORMS.IOS){var l="baiduboxapp://callShare?options="+encodeURIComponent(JSON.stringify(i))+"&errorcallback="+t.f+"&successcallback="+t.s;location.href=l}return!1}if(clouda.RUNTIME===clouda.RUNTIMES.LIGHTSDK){var o=i.mediaType||"all",r={all:0,sinaweibo:1,weixin_friend:2,weixin_timeline:3,sms:4},c={title:i.title||"来自百度直达号",url:i.linkUrl,content:i.content+" "+i.linkUrl,img_url:i.imageUrl,weixin_description:i.content,thumb_img_url:i.iconUrl||i.imageUrl,weixin_send_url:!0};return c.weibo_title=c.weixin_title=c.weixin_timeline_title=i.title,c.share_type=r[o]||0,void clouda.lightsdk(i.onsuccess,i.onfail,"device.share","directShare",c)}if("undefined"!=typeof uix_bridge){var t=clouda.lib.utils.regcallback(i.onsuccess,i.onfail);return void uix_bridge.callShare(JSON.stringify(i),t.s,t.f)}if(clouda.RUNTIME===clouda.RUNTIMES.NUWA&&clouda.NUWA_VERSION>="2.6"){{clouda.lightInit.ak||clouda.lightapp.ak}0!==i.menumode&&(i.menumode=1),i.linkUrl=i.linkUrl||location.href,i.imageUrl=i.imageUrl||"",i.mediaType=i.mediaType||"all";var d=function(){i.onsuccess(clouda.STATUS.SUCCESS)},u=function(){a.error(ErrCode.BTY_ERR,nativeErr,i)};return nuwa&&nuwa.sm&&"function"==typeof nuwa.sm.share?nuwa.sm.share(d,u,JSON.stringify(i)):document.addEventListener("runtimeready",function(){nuwa.sm.share(d,u,JSON.stringify(i))}),!1}return e(i),!1},t.checkSupport=function(e){var i={};clouda.RUNTIME===clouda.RUNTIMES.NUWA?i["native"]=0:clouda.RUNTIME===clouda.RUNTIMES.KUANG?i["native"]=BLightApp&&"function"==typeof BLightApp.callShare?1:0:clouda.RUNTIME===clouda.RUNTIMES.WEB&&(i["native"]=navigator.userAgent.match(/baiduboxapp\/([\d+.]+)/)&&clouda.RUNTIME_VERSION>="5.3.5"?1:0),i.web=1,e(i)},t});