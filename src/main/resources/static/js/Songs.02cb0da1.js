(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["Songs"],{"5b32":function(t,e,n){},"706e":function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"songs"},[n("div",{staticClass:"tabs"},[n("Tabs",{attrs:{tabs:t.tabs,align:"right",type:"small"},on:{tabChange:t.getSongs},model:{value:t.activeTabIndex,callback:function(e){t.activeTabIndex=e},expression:"activeTabIndex"}})],1),n("SongTable",{attrs:{songs:t.songs,"header-row-class-name":"header-row"}})],1)},s=[],r=(n("7f7f"),n("96cf"),n("3b8d")),i=n("365c"),c=n("ed08"),o=n("a110"),u={created:function(){var t=Object(r["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:this.tabs=[{title:"全部",type:0},{title:"华语",type:7},{title:"欧美",type:96},{title:"日本",type:8},{title:"韩国",type:16}],this.getSongs();case 2:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),data:function(){return{activeTabIndex:0,songs:[]}},methods:{getSongs:function(){var t=Object(r["a"])(regeneratorRuntime.mark((function t(){var e,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(i["y"])(this.tabs[this.activeTabIndex].type);case 2:e=t.sent,n=e.data,this.songs=n.map((function(t){var e=t.id,n=t.name,a=t.artists,s=t.duration,r=t.mvid,i=t.album,o=i.picUrl,u=i.name;return Object(c["createSong"])({id:e,name:n,artists:a,duration:s,albumName:u,img:o,mvId:r})}));case 5:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}()},components:{SongTable:o["a"]}},l=u,b=(n("715f"),n("2877")),d=Object(b["a"])(l,a,s,!1,null,null,null);e["default"]=d.exports},"715f":function(t,e,n){"use strict";var a=n("5b32"),s=n.n(a);s.a}}]);