var app = getApp()
Page({
  data: {
    navData: [
      {
        text: '射击游戏'
      },
      {
        text: '角色扮演'
      },
      {
        text: '动作游戏'
      },
      {
        text: '即时战略'
      },
      {
        text: '体育格斗'
      },
      {
        text: '赛车竞速'
      },
      {
        text: '模拟经营'
      },
      {
        text: '其他游戏'
      }
    ],
    currentTab: 0,
    navScrollLeft: 0,
    list : []
  },
  switchNav(event) {
    var cur = event.currentTarget.dataset.current;
    //每个tab选项宽度占1/5
    var singleNavWidth = this.data.windowWidth / 5;
    //tab选项居中                            
    this.setData({
      navScrollLeft: (cur - 2) * singleNavWidth
    })
    console.log(this.navScrollLeft)
    if (this.data.currentTab == cur) {
      return false;
    } else {
      this.setData({
        currentTab: cur
      })
    }
  },
  switchTab(event) {
    var cur = event.detail.current;
    var singleNavWidth = this.data.windowWidth / 5;
    this.setData({
      currentTab: cur,
      navScrollLeft: (cur - 2) * singleNavWidth
    });
    console.log(this.data.navScrollLeft)
    console.log(this.data.navData[cur].text)
    let that = this
    wx.request({
      url: 'http://localhost:8080/jump/game/getGameByType',
      data: { gameType: this.data.navData[cur].text },
      method: 'GET',
      success: function (res) {
        let list = res.data.list;
        console.log(res.data.list)
        // let str = list.commentsTime.split("T");
        // list.commentsTime = str[0];
        if (list == undefined) {
          let toastText = '获取失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          // console.log(commentsTime))
          that.setData({
            list: list
          });
        }
      }
    })
  },
  onLoad: function () {
    // wx.getSystemInfo({
    //   success: (res) => {
    //     this.setData({
    //       pixelRatio: res.pixelRatio,
    //       windowHeight: res.windowHeight,
    //       windowWidth: res.windowWidth
    //     })
    //   },
    // })
    let that = this
    wx.request({
      url: 'http://localhost:8080/jump/game/getGameByType',
      data: { gameType: '射击游戏' },
      method: 'GET',
      success: function (res) {
        let list = res.data.list;
        console.log(res.data.list)
        // let str = list.commentsTime.split("T");
        // list.commentsTime = str[0];
        if (list == undefined) {
          let toastText = '获取失败' + res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        } else {
          // console.log(commentsTime))
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