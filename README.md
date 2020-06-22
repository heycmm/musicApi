# musicApi

一个轻量级Java音乐api

## 环境要求

java 8

redis 

## 部署

也可以直接在<a href="https://github.com/proxygit/musicApi/releases" target="_blank">releases</a>下载

mvn package

cd target

java -jar musicApi.jar

## 食用方法

### 网易云会员登陆：

`curl "http://127.0.0.1:8097/loginCellphone?phone=你的手机号&password=密码"`

成功后将会往redis存入你的登陆cookie

验证登陆状态(每日歌曲推荐接口)：`curl "http://127.0.0.1:8097/recommendSongs"`

### qq音乐会员登陆:
 
 去`https://y.qq.com/portal/profile.html`

登陆后

打开浏览器控制台:`document.cookie`

`curl -d "strCookie=你获取到到cookie值" "http://127.0.0.1:8097/qq/saveCookie"`

测试2个vip歌曲（如果你是vip到话）

qq音乐绿钻

浏览器访问`http://127.0.0.1:8097/player?id=003gE47J4Kuldb&type=1` 全世界失眠 - 陈奕迅

网易云黑胶会员

浏览器访问`http://127.0.0.1:8097/player?id=208902&type=0` 红色高跟鞋 - 蔡健雅

## 网页嵌入方法

```
<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" border="0" scrolling="no" allowtransparency="yes" width=100% height=102 src="//上面测试的2个链接
"></iframe>
```

## 相关来源

利用[lets-blade/Blade](https://github.com/lets-blade/blade)构建


[Binaryify/NeteaseCloudMusicApi](https://github.com/Binaryify/NeteaseCloudMusicApi)


## 客户端

https://github.com/sl1673495/vue-netease-music
