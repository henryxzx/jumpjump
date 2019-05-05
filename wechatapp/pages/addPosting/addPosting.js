Page({
  data: {
    gameId: undefined,
    evaContent: '',
    gameCommunityId: undefined
  },
  onLoad: function (options) {
    let that = this;
    this.setData({
      gameId: options.gameId,
      gameCommunityId: options.gameCommunityId 
    });
    console.log(this.data.gameId)
    console.log(this.data.gameCommunityId)
    if (options.gameId == undefined) {
      return;
    }
    wx.request({
      url: 'http://localhost:8080/jump/game/getGameById',
      data: { 'gameId': options.gameId },
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
            // gamePublishTime: game.gamePublishTime,
            // gamePublisherName: game.gamePublisher.gamePublisherName,
            // gameTypeName: game.gameType.gameTypeName,
            // gameContent: game.gameContent,
            // gameScore: game.gameScore
          });
        }
      }
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
  textBlur: function (e) {
    console.log(e.detail.value)
    if (e.detail && e.detail.value.length > 0) {
      if (e.detail.value.length < 12 || e.detail.value.length > 500) {
        //app.func.showToast('内容为12-500个字符','loading',1200);
      } else {
        this.setData({
          evaContent: e.detail.value
        });
      }
    } else {
      this.setData({
        evaContent: ''
      });
      
    }
  },
  titleBlur:function(e){
    console.log(e.detail.value)
    if (e.detail && e.detail.value.length > 0) {
      this.setData({
        evaTitle: e.detail.value
      })
      }else {
      this.setData({
        evaTitle: ''
      });

    }
  },
  evaSubmit: function (eee) {
    // console.log(eee.detail.value)
    var that = this;
    // console.log(wx.getStorageSync("uId")),
    //   console.log(eee.detail.value.evaContent),
    // console.log(that.data.gameId),
    // console.log(that.data.isRecommend)
    wx.request({
      method: "post",
      header: {
        "content-type": "application/x-www-form-urlencoded"
      },
      url: "http://localhost:8080/jump/gameCommunity/addPosting",
      data: {
        gameCommunityPostingUid : wx.getStorageSync("uId"),
        gameCommunityPostingTitle: that.data.evaTitle,
        gameCommunityPostingContent: that.data.evaContent,
        gameCommuntiyPostingGameCommuntiyId: that.data.gameCommunityId,
        
      },

      success: function (res) {
        if(res.data.success){
        wx.showModal({
          title: '发帖成功！',
          content: '',
          showCancel: false,
          success(res) {
            if (res.confirm) {
              wx.navigateBack({
                delta: 1
              })
            }
          }
        })
        }else{
          wx.showModal({
            title: '发帖失败！',
            content: '',
            showCancel: false,
            success(res) {
              if (res.confirm) {
                wx.navigateBack({
                  delta: 1
                })
              }
            }
          })
        }
      }
    })

  }
})