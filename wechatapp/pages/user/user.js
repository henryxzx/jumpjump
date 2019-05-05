//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    selectPerson: true,
    firstPerson: '个人',
    selectArea: false
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
   clickPerson:function(){
    var selectPerson = this.data.selectPerson;
    if(selectPerson == true){
     this.setData({
     selectArea:true,
     selectPerson:false,
  })
    }else{
     this.setData({
     selectArea:false,
     selectPerson:true,
  })
    }
  } ,
  //点击切换
  mySelect:function(e){
   this.setData({
     firstPerson:e.target.dataset.me,
     selectPerson:true,
     selectArea:false,
   })
  },
  onLoad: function (e) {
    // if (app.globalData.userInfo) {
    //   this.setData({
    //     userInfo: app.globalData.userInfo,
    //     hasUserInfo: true
    //   })
    // } else if (this.data.canIUse){
    //   // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    //   // 所以此处加入 callback 以防止这种情况
    //   app.userInfoReadyCallback = res => {
    //     this.setData({
    //       userInfo: res.userInfo,
    //       hasUserInfo: true
    //     })
    //     console.log(res.userInfo)
    //   }
    // } else {
    //   // 在没有 open-type=getUserInfo 版本的兼容处理
    //   wx.getUserInfo({
    //     success: res => {
    //       app.globalData.userInfo = res.userInfo
    //       this.setData({
    //         userInfo: res.userInfo,
    //         hasUserInfo: true
    //       })
    //     }
    //   })
    // }
  },
  getUserInfo: function(e) {
    // console.log(app.globalData.openid)

  },

  bindGetUserInfo: function (e) {
    if (e.detail.userInfo) {
      console.log(e.detail.userInfo)
      //用户按了允许授权按钮
      var that = this;
      app.globalData.userInfo = e.detail.userInfo
      this.setData({
        userInfo: e.detail.userInfo,
        hasUserInfo: true
      })
      //插入登录的用户的相关信息到数据库
      // wx.request({
      //   url: app.globalData.urlPath + 'user/add',
      //   data: {
      //     openid: getApp().globalData.openid,
      //     nickName: e.detail.userInfo.nickName,
      //     avatarUrl: e.detail.userInfo.avatarUrl,
      //     province: e.detail.userInfo.province,
      //     city: e.detail.userInfo.city
      //   },
      //   header: {
      //     'content-type': 'application/json'
      //   },
      //   success: function (res) {
      //     //从数据库获取用户信息
      //     that.queryUsreInfo();
      //     console.log("插入小程序登录用户信息成功！");
      //   }
      // });
      wx.login({
        success(res) {
          if (res.code) {
            // 发起网络请求
            console.log(res.code)
            wx.request({
              method : "post",
              header : {
                "content-type":"application/x-www-form-urlencoded"
              },
              url: "http://localhost:8080/jump/User/login",
              data: {
                code: res.code,
                userInfo: JSON.stringify(e.detail.userInfo),
              },
              success: function(res){
                wx.setStorageSync("openid", res.data.openid)
                wx.setStorageSync("uId", res.data.uId)
                wx.showModal({
                  title: res.data.success,
                  // title: "?",
                  content: '登录成功！'
                })
                // console.log(res)
                console.log(wx.getStorageSync("openid"))
              }
            })

          } else {
            console.log('登录失败！' + res.errMsg)
          }
        }
      })
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击了“返回授权”')
          }
        }
      })
    }
  }
})
