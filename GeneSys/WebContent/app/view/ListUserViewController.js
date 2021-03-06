/*
 * File: app/view/ListUserViewController.js
 *
 * This file was generated by Sencha Architect version 4.2.2.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 6.5.x Classic library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 6.5.x Classic. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Booking.view.ListUserViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.listuser',
    
    onSearchBookingView : function(button, e, eOpts) {
    	Ext.getCmp('SearchBookingView').show();
    	Ext.getCmp('ListUserView').destroy();
    },
    
    onLogOutClick: function(button, e, eOpts) {
    	Ext.getBody().mask();
    	Ext.create('Ext.window.Window', {
            title: 'User Logout',
            id: 'LogoutWndowId',
            layout: {
            	type: 'vbox',
                align: 'stretch'
            },
            width: 250,
            height: 100,
            listeners: {
                close: {
                    scope: this,
                    fn: function () {
                    	Ext.getBody().unmask();
                    	window.location.reload();
                        var win = Ext.getCmp('LogoutWndowId');
                        win.destroy();
                    }
                }
            },
            items: [
            	{
            		 xtype: 'container',
                     id: 'LogoutWndowContainrId',
                     padding: '10',
                     layout: {
                         type: 'vbox',
                         align: 'stretch'
                     },
                     items: [
                    	 {
		            		xtype: 'label',
		                    text: 'You have successfully logged out.'
                    	 },
                    	 {
                    		 xtype: 'button',
                             text: 'Confirm',
                             margin: '10 0 0 0',
                             listeners: {
                                 click: {
                                	 scope: this,
                                	 fn: function(){
                                		Ext.Ajax.request({
                                  			url : 'logout',
                                  			params : { },
                                  			scope : this,
                                  			success : function(response) {
                                  				//setTimeout(function() { window.location.reload(); }, 1000);
                                  				Ext.getCmp('LogoutWndowId').close();
                                  				window.location.reload();
                                  			}
                                      	});
                                	 }
                                 }
                             }
                    	 }
                    ]
            	}
            ]
		}).show();
    },
    
	onSearchUserClick: function() {
    	Ext.getStore('UserStore').removeAll();
    	var store = Ext.getStore('UserStore');
		Ext.Ajax.request({
			url : 'user/listUser',
			method : 'POST',
			datatype : 'json',
			params : {

			},
			scope : this,
			success : function(response) {
				var data = Ext.decode(response.responseText);
				Ext.each(data, function(record) {
					var userRole = 'User';
					if(record.role == 1){
						userRole = 'Admin';
					}else if(record.role == 2){
						userRole = 'CSV';
					}else if(record.role == 3){
						userRole = 'User';
					}
					var users = {
							Username : record.username,
				            Password : record.password,
				            Role : userRole,
				            Email : record.email,
				    		FirstName : record.firstName,
				    		LastName : record.lastName
					};
					store.add(users);
				});
			}
		});
    },

    onSaveUser : function(data) {
    	console.log(data[0].Username);
		  Ext.Ajax.request({
				url : 'user/addUser',
				method : 'POST',
				params : {
		        	username : data[0].Username==null?'':data[0].Username,
	            	password : data[0].Password==null?'':data[0].Password,
	            	role :data[0].Role==null?'':data[0].Role,
	            	email : data[0].Email==null?'':data[0].Email,
	            	firstName : data[0].FirstName==null?'':data[0].FirstName,
	            	lastName : data[0].LastName==null?'':data[0].LastName,
				},
				scope : this,
				success : function(response) {
					Ext.getCmp("addUserWindowId").close();
					Ext.Msg.alert("Message", "User successfully saved!");
					console.log("user saved!");
				}
			});	
	},
    onSaveUpdateUser : function(data) {
    	console.log(data[0].Username);
		  Ext.Ajax.request({
				url : 'user/updateUser',
				method : 'POST',
				params : {
		        	username : data[0].Username==null?'':data[0].Username,
	            	password : data[0].Password==null?'':data[0].Password,
	            	role :data[0].Role==null?'':data[0].Role,
	            	email : data[0].Email==null?'':data[0].Email,
	            	firstName : data[0].FirstName==null?'':data[0].FirstName,
	            	lastName : data[0].LastName==null?'':data[0].LastName,
				},
				scope : this,
				success : function(response) {
					Ext.getCmp("updateUserWindowId").close();
					this.onSearchUserClick();
					Ext.Msg.alert("Message", "User successfully updated.");
					console.log("user updated!");
				}
			});	
	},
    onAddUser: function(button, e, eOpts) {
        Ext.getBody().mask();
        Ext.create('Ext.window.Window', {
            title: 'AddUser',
            id: 'addUserWindowId',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            listeners: {
                close: {
                    scope: this,
                    fn: function () {
                        Ext.getBody().unmask();
                    }
                }
            },
            items: [
            {
                xtype: 'container',
                id: 'adContainerId',
                padding: '10',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Username',
                    id:'adUsername',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Password',
                    allowBlank: false
                },
                {
                	xtype: 'combobox',
                    fieldLabel: 'Role',
                    id: 'AddUsrRoleListId',
                    allowBlank: false,
                    displayField: 'name',
                    forceSelection: true,
                    queryMode: 'local',
                    store: 'UserRoleStore',
                    valueField: 'code'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Email',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'First Name',
                    allowBlank: false
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Last Name',
                    allowBlank: false
                }]
            },
            {
                xtype: 'container',
                padding: '0 0 10 10',
                layout: {
                    type: 'hbox',
                    align: 'stretch'
                },
                items: [{
                    xtype: 'button',
                    text: 'Add',
                    id: 'adSaveUser',
                    listeners: {
                        click: {
                            scope: this,
                            fn: function () {
                                var cmp = Ext.getCmp('adContainerId');
                                var containerCmp = cmp.items.getRange();
                                var store = Ext.getStore('UserStore');
                                var errors = [], data = [];
                                var username, password, role, email, firstname, lastname;

                                //Get component errors
                                for(var i=0; i<containerCmp.length; i++){
                                    if(!Ext.isEmpty(containerCmp[i].getErrors())){
                                        errors.push(containerCmp[i].getErrors());
                                    }
                                }
                                if(errors.length > 0 ){
                                    var isMissingField = false;
                                    errors.forEach(function(i){
                                        if(i=='This field is required'){
                                            isMissingField = true;
                                        }
                                    });
                                    if(isMissingField){
                                        Ext.MessageBox.alert('Waring!','Please fill up all fields to add!');
                                    }else{
                                        Ext.MessageBox.alert('Waring!','Please correct all invalid fields!');
                                    }
                                }else{
                                    for(var x=0; x<containerCmp.length; x++){
                                        //data.push(containerCmp[x].getValue());
                                        if(x===0){
                                        	username = containerCmp[x].getValue();
                                        }else if(x===1){
                                            password = containerCmp[x].getValue();
                                        }else if(x===2){
                                            role = containerCmp[x].getValue();
                                        }else if(x===3){
                                            email = containerCmp[x].getValue();
                                        }else if(x===4){
                                            firstname = containerCmp[x].getValue();
                                        }else if(x===5){
                                            lastname = containerCmp[x].getValue();
                                        }
                                    }
                                    data.push({Username:username, Password:password,
                                    Role:role, Email:email, FirstName:firstname, LastName:lastname});
                                    store.add(data);
                                    this.onSaveUser(data);
                                }
                            }
                        }
                    }
                }]
            }]
        }).show();
    },

	onDeleteUser: function(button, e, eOpts) {
		var cmp = Ext.getCmp('userList');
        var selected = cmp.getSelection();
        var store = Ext.getStore('UserStore');
        console.log(selected[0].data);
        
        
        Ext.Ajax.request({
			url : 'user/deleteUser',
			method : 'POST',
			params : {
				userParam : Ext.util.JSON.encode(selected[0].data),
			},
			scope : this,
			success : function(response) {
				Ext.Msg.alert("Message", "User successfully deleted.");
				console.log("deleted!");
			}
		});
       
        if(!Ext.isEmpty(selected)){
            store.remove(selected);
        }
	},
	
	onUpdateUser: function(button, e, eOpts) {
		if(Ext.getCmp("userList").getSelection()[0] != null){ 
		Ext.getBody().mask();
        Ext.create('Ext.window.Window', {
            title: 'Update User',
            id: 'updateUserWindowId',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            listeners: {
                close: {
                    scope: this,
                    fn: function () {
                        Ext.getBody().unmask();
                    }
                },
                show: {
                    scope: this,
                    fn: function () {
                    	var userList = Ext.getCmp("userList").getSelection()[0].data.Role;
                        var userListCmp = Ext.getCmp('UpdUsrRoleListId');
                        if(userList=='Admin'){
                        	userListCmp.setValue(1);
                        }else if(userList=='CSV'){
                        	userListCmp.setValue(2);
                        }else if(userList=='User'){
                        	userListCmp.setValue(3);
                        }
                    }
                }
            },
            items: [
            {
                xtype: 'container',
                id: 'upContainerId',
                padding: '10',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    xtype: 'textfield',
                    fieldLabel: 'Username',
                    id:'upUsername',
                    disabled : true,
                    allowBlank: false,
                    value: Ext.getCmp("userList").getSelection()[0].data.Username
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Password',
                    allowBlank: false,
                    value: Ext.getCmp("userList").getSelection()[0].data.Password
                },
                {
                    xtype: 'combobox',
                    fieldLabel: 'Role',
                    id: 'UpdUsrRoleListId',
                    allowBlank: false,
                    displayField: 'name',
                    forceSelection: true,
                    queryMode: 'local',
                    store: 'UserRoleStore',
                    valueField: 'code'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Email',
                    allowBlank: false,
                    value: Ext.getCmp("userList").getSelection()[0].data.Email
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'First Name',
                    allowBlank: false,
                    value: Ext.getCmp("userList").getSelection()[0].data.FirstName
                },
                {
                    xtype: 'textfield',
                    fieldLabel: 'Last Name',
                    allowBlank: false,
                    value: Ext.getCmp("userList").getSelection()[0].data.LastName
                }]
            },
            {
                xtype: 'container',
                padding: '0 0 10 10',
                layout: {
                    type: 'hbox',
                    align: 'stretch'
                },
                items: [{
                    xtype: 'button',
                    text: 'Update',
                    id: 'updateUserButton',
                    listeners: {
                        click: {
                            scope: this,
                            fn: function () {
                                var cmp = Ext.getCmp('upContainerId');
                                var containerCmp = cmp.items.getRange();
                                var store = Ext.getStore('UserStore');
                                var errors = [], data = [];
                                var username, password, role, email, firstname, lastname;

                                //Get component errors
                                for(var i=0; i<containerCmp.length; i++){
                                    if(!Ext.isEmpty(containerCmp[i].getErrors())){
                                        errors.push(containerCmp[i].getErrors());
                                    }
                                }
                                if(errors.length > 0 ){
                                    var isMissingField = false;
                                    errors.forEach(function(i){
                                        if(i=='This field is required'){
                                            isMissingField = true;
                                        }
                                    });
                                    if(isMissingField){
                                        Ext.MessageBox.alert('Waring!','Please fill up all fields to add!');
                                    }else{
                                        Ext.MessageBox.alert('Waring!','Please correct all invalid fields!');
                                    }
                                }else{
                                    for(var x=0; x<containerCmp.length; x++){
                                        //data.push(containerCmp[x].getValue());
                                        if(x===0){
                                        	username = containerCmp[x].getValue();
                                        }else if(x===1){
                                            password = containerCmp[x].getValue();
                                        }else if(x===2){
                                            role = containerCmp[x].getValue();
                                        }else if(x===3){
                                            email = containerCmp[x].getValue();
                                        }else if(x===4){
                                            firstname = containerCmp[x].getValue();
                                        }else if(x===5){
                                            lastname = containerCmp[x].getValue();
                                        }
                                    }
                                    data.push({Username:username, Password:password,
                                    Role:role, Email:email, FirstName:firstname, LastName:lastname});
                                    store.add(data);
                                    this.onSaveUpdateUser(data);
                                }
                            }
                        }
                    }
                }]
            }]
        }).show();
		}
	},


	
});
