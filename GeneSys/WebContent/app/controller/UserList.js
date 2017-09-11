Ext.define('Booking.controller.UserList', {
    extend: 'Ext.app.Controller',

    control: {
        "#searchUser": {
            click: 'onSearchUserClick'
        }
    },
    onSearchUserClick: function(component, eOpts) {
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
    }

});