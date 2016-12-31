Ext.define('iih.sy.userinfo.action.ShowSignPicAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {/*
		var owner = this.getOwner();
		var block = this.getBlock('content');
		var photo = block.down('filefield');
		var signPicture = photo.value;
		var showSignPic = block.down('imagecomponent');
		showSignPic.setSrc(signPicture);
	*/
		var owner = this.getOwner();
		var block = this.getBlock('result');
		var photo = block.down('filefield');
		var img = photo.value;
		var image = new Image();
		image.src = img;
		var signPictureShow;
		image.onload = function(){
			var canvas = document.createElement("canvas");
	        canvas.width = image.width;
	        canvas.height = image.height;
	        var ctx = canvas.getContext("2d");
	        ctx.drawImage(image, 0, 0, image.width, image.height);
	        var ext = image.src.substring(image.src.lastIndexOf(".")+1).toLowerCase();
	        signPictureShow = canvas.toDataURL("image/"+ext);
//	        console.log(signPictureShow.substring(22,signPictureShow.length));
	        var showSignPic = block.down('imagecomponent');
			showSignPic.setSrc(signPictureShow);
		}
		
	}
});
