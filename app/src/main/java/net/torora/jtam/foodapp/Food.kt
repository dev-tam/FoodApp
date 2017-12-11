package net.torora.jtam.foodapp

/**
 * Created by jtam on 12/12/17.
 */
class Food{
    var name:String?=null
    var image:Int?=null
    var des:String?=null
    constructor(name:String,des:String,image: Int){
        this.name=name
        this.image=image
        this.des=des
    }
}