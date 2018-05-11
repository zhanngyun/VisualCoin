// pages/game/game.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      'color':{
        'shu':'',
        'niu':'',
        'hu':'',
        'tu': '',
        'long': '',
        'she': '',
        'ma': '',
        'yang': '',
        'hou': '',
        'ji': '',
        'gou': '',
        'zhu': '',
      }
  },
  //十二生肖被选中
  selected:function(e){

    var id = ''+e.currentTarget.id
    this.setData({ 'shu': '', 'niu': '', 'hu': '', 'tu': '', 'long': '', 'she': '', 'ma': '', 'yang': '', 'hou': '', 'ji': '', 'gou': '', 'zhu': ''})
    if(id=='shu'){
      this.setData({ 'shu': 'selected' })
    }else if(id=='niu'){
      this.setData({ 'niu': 'selected' })
    }else if(id=='hu'){
      this.setData({ 'hu': 'selected' })
    } else if (id == 'tu'){
      this.setData({ 'tu': 'selected' })
    } else if (id == 'long') {
      this.setData({ 'long': 'selected' })
    } else if (id == 'she') {
      this.setData({ 'she': 'selected' })
    } else if (id == 'ma') {
      this.setData({ 'ma': 'selected' })
    } else if (id == 'yang') {
      this.setData({ 'yang': 'selected' })
    } else if (id == 'hou') {
      this.setData({ 'hou': 'selected' })
    } else if (id == 'ji') {
      this.setData({ 'ji': 'selected' })
    } else if (id == 'gou') {
      this.setData({ 'gou': 'selected' })
    } else{
      this.setData({ 'zhu': 'selected' })
    }
  }
  ,

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