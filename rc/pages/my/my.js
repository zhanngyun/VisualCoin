// pages/my/my.js
//获取应用实例
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "myBg":"../../images/1.jpg",
    "userInfoFollower":200,
    "showView":false,
    "functionContainer":{
      "postListNum":23,
      "collectionListNum":7,
      "followListNum":65
    },
    'tag': true
    ,
    'userInfo': {
      "nickName":"の苁ヅ蕶╓開始", "avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/RQCuDQnImhtrib5dvcu8bT3GITHhTdc9pzhA9GwNZ6VOY2nBUPv2MibVyqHic6urrFvUrcIFaVHL4tMZBlQCuDkMg/0"
    }
  },
  /**
   *关于我们
   */
  VIP:function(){
    wx.navigateTo({
      url: 'VIP'
    })
  },
   /**
   * 更换头像
   */
  changeTheBackground:function(){
    this.setData({ "showView": !this.data.showView})
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo
      })
    } else {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      // 获取用户信息
      wx.getSetting({
        success: res => {
          if (res.authSetting['scope.userInfo']) {
            // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
            wx.getUserInfo({
              success: res => {
                // 可以将 res 发送给后台解码出 unionId
                this.setData({
                  userInfo: res.userInfo
                })
              }
            })
          }
        }
      })
    }
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
  
  }
})