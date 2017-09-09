Ext.define('Booking.controller.UserList', {
    extend: 'Ext.app.Controller',

    control: {
        "#searchUser": {
            click: 'onSearchUserClick'
        }
    },
    onSearchUserClick: function(component, eOpts) {
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
					var users = {
							Username : record.username,
				            Password : record.password,
				            Role : record.role,
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