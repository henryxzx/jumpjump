Page({
  data: {
    list: []
  },
  onLoad: function () {
    let that = this;
    wx.request({
      url: 'http://localhost:8080/jump/recommend/listById',
      method: 'GET',
      data: {
        uId: wx.getStorageSync("uId")
      },
      success: function (res) {
        let list = res.data.List;
        if (list == null) {
          let toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          })
        } else {
          that.setData({
            list: list
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
})