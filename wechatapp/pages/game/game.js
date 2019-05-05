const util = require('../../utils/util.js')

var app = getApp()
Page({
  data: {
    navbar: ['游戏信息', '评测', '社区'],
    currentTab: 0,
    gameId : undefined,
    gameTitle: '',
    list : [],
    listPosting: [],
    gameCommunityImage: "",
    gameCommunityId: undefined
  },
  navbarTap: function (e) {
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
    if (e.currentTarget.dataset.idx == 0){
    } else if (e.currentTarget.dataset.idx == 1){
      let that = this
      wx.request({
        url: 'http://localhost:8080/jump/comments/listByGameId',
        data:{gameId: that.data.gameId},
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
              list : list
            });
          }
        }
      })
    }else if(e.currentTarget.dataset.idx == 2){
      let that = this
      wx.request({
        url: 'http://localhost:8080/jump/gameCommunity/getByGameId',
        data: { gameId: that.data.gameId },
        method: 'GET',
        success: function (res) {
          if (res.data == undefined) {
            let toastText = '获取失败' + res.data.errMsg;
            wx.showToast({
              title: toastText,
              icon: '',
              duration: 2000
            });
          } else {
            that.setData({
              gameCommunityImage: res.data.community.gameCommunityImage,
              gameCommunityId: res.data.community.gameCommunityId
            });
            wx.request({
              url: 'http://localhost:8080/jump/gameCommunity/getPostingById',
              data: { gameCommunityId: that.data.gameCommunityId },
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
                    listPosting: list
                  });
                  console.log(list)
                }
              }
            })
          }
        }
      })
    }
  },
  onLoad: function (options) {
    let that = this;
    this.setData({
      gameId: options.gameId
    });
    console.log(options.gameId)
    // if (options.gameId == undefined) {
    //   return;
    // }
    wx.request({
      url: 'http://localhost:8080/jump/game/getGameById',
      data: { gameId: options.gameId },
      method: 'GET',
      success: function (res) {
        let game = res.data.game;
        if (game == undefined) {
          let toastText = '获取失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          that.setData({
            gameTitle: game.gameName,
            gamePublishTime: game.gamePublishTime,
            gamePublisherName: game.gamePublisher,
            gameTypeName: game.gameType.gameTypeName,
            gameContent: game.gameContent,
            gameScore: game.gameScore,
            gameImage: game.gameImage
          });
        }
      }
    })
  },
    onReady: function () {
        // 页面渲染完成
    },
    onShow: function (options) {
        // 页面显示
    },
    onHide: function () {
        // 页面隐藏
    },
    onUnload: function () {
        // 页面关闭
    },
  recommend : function(options){
    this.data.isRecommend = 1
    console.log(this.data.gameId)
    if(wx.getStorageSync("openid") != ''){
      wx.navigateTo({
        url: '/pages/comments/comments?gameId=' + this.data.gameId+'&isRecommend=1',
      })
    }else{
      wx.showModal({
        title: '未登录！',
        content: '请登录后再试',
      })
    }
  },
  norecommend: function (options) {
    console.log(this.data.gameId)
    if (wx.getStorageSync("openid") != '') {
      wx.navigateTo({
        url: '/pages/comments/comments?gameId=' + this.data.gameId + '&isRecommend=0',
      })
    } else {
      wx.showToast({
        title: '未登录，请登录后再试',
      })
    }
  },
  addPosting: function(options){
    wx.navigateTo({
      url: '/pages/addPosting/addPosting?gameId='+this.data.gameId+'&gameCommunityId='+this.data.gameCommunityId,
    })
  }

})