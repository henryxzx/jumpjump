var app = getApp()
Page({
  data: {
    navbar: ['游戏信息', '评测', '社区'],
    currentTab: 0,
    gameCommunityPostingId : undefined,
    list:[]
  },
  navbarTap: function (e) {
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
  },
  onLoad: function (options) {
    let that = this;
    this.setData({
      gameCommunityPostingId: options.gameCommunityPostingId
    });
    wx.request({
      url: 'http://localhost:8080/jump/gameCommunity/getPostingContentById',
      data: { gameCommunityPostingId: options.gameCommunityPostingId },
      method: 'GET',
      success: function (res) {
        let posting = res.data.posting;
        if (posting == undefined) {
          let toastText = '获取失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            gameCommunityPostingTitle: posting.gameCommunityPostingTitle,
            gameCommunityPostingContent: posting.gameCommunityPostingContent,
            uNickName: posting.user.uNickName,
            uAvatarUrl: posting.user.uAvatarUrl,
            gameCommunityPostingTime: posting.gameCommunityPostingTime
          });
          wx.request({
            url: 'http://localhost:8080/jump/gameCommunity/getPostingEvaluateById',
            data: { gameCommunityPostingId: that.data.gameCommunityPostingId },
            method: 'GET',
            success: function (res) {
              let list = res.data.list;
              if (list == undefined) {
                let toastText = '获取失败' + res.data.errMsg;
                wx.showToast({
                  title: toastText,
                  icon: '',
                  duration: 2000
                });
              } else {
                that.setData({
                  list: list
                });
                console.log(list)
              }
            }
          })

        }
      }
    })
  },
  addEvaluate: function(){
    wx.navigateTo({
      url: '/pages/addPostingEvaluate/addPostingEvaluate?gameCommunityPostingId=' + this.data.gameCommunityPostingId,
    })
  },
  
    onReady: function () {
        // 页面渲染完成
    },
    onShow: function () {
        // 页面显示
    },
    onHide: function () {
        // 页面隐藏
    },
    onUnload: function () {
        // 页面关闭
    },
})