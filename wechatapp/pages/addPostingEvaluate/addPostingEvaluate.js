Page({
  data: {
    gameId: undefined,
    gameTitle: '',
    evaContent: '',
    gameCommunityPostingId: undefined
  },
  onLoad: function (options) {
    let that = this;
    this.setData({
      gameCommunityPostingId: options.gameCommunityPostingId
    });
    console.log(this.data.gameCommunityPostingId)
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
      url: "http://localhost:8080/jump/gameCommunity/addPostingEvaluate",
      data: {
        gameCommunityPostingEvaluateUid : wx.getStorageSync("uId"),
        gameCommunityPostingEvaluateConetent: eee.detail.value.evaContent,
        gameCommunityPostingEvaluatePostingId: that.data.gameCommunityPostingId,
      },

      success: function (res) {
        if(res.data.success){
        wx.showModal({
          title: '评论成功！',
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
            title: '评论失败！',
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