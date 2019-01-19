// pages/list/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[]

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    let that = this;
    wx.request({
      url: 'http://127.0.0.1:8080/xqy/superadmin/listarea',
      method: 'GET',
      data : {},
      success: function(res){
        let list = res.data.areaList;
        if (list == null){
          let toastText = '获取数据失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          })
        }else{
          that.setData({
            list: list
          });
        }

      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  addArea: function(){
    wx.navigateTo({
      url: '../operation/operation',
    })
  },

  deleteArea: function(e){
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确定删除区域['+ e.target.dataset.areaname + ']吗？',
      success: function(sm){
        if(sm.confirm){
          wx.request({
            url: 'http://127.0.0.1:8080/xqy/superadmin/deletearea',
            data: {'areaId':e.target.dataset.areaid},
            method:'GET',
            success: function(res){
              let result = res.data.success;
              let toastText = '删除成功';
              if(result != true){
                toastText = '删除失败';
              }else{
                that.data.list.splice(e.target.dataset.index, 1);
                that.setData({
                  list: that.data.list
                });
              }
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000
              })
        
            }
          })
        }
      }
    })
  }
})