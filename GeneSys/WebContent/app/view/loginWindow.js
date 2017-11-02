/*
 * File: app/view/loginWindow.js
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

Ext.define('Booking.view.loginWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.loginWindow',
    id: 'loginWindow',
    requires: [
        'Booking.view.loginWindowViewModel',
        'Ext.Img',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Fill',
        'Ext.container.ButtonGroup',
        'Ext.button.Button'
    ],

    viewModel: {
        type: 'loginwindow'
    },
    autoShow: true,
    draggable: false,
    flex: 1,
    padding: 20,
    resizable: false,
    width: 394,
    layout: 'center',
    closable: false,
    placeholderCollapseHideMode: 3,
    title: '',
    
    dockedItems: [
    	 {
         	xtype: 'container',
         	flex: 1,
         	layout: {
         		type: 'auto',
         		//align: 'center'
         	},
             items: [
             	{
             		margin: '0 0 10 15',
             		xtype: 'image',
             		flex: 1,
                     //  dock: 'top',
                       height: 100,
                       width: 310,
                       src: 'brand2.png'
             	}
             ]
         },
        {
            xtype: 'textfield',
            dock: 'top',
            flex: 1,
            itemId: 'username',
            id: 'username',
            margin: 10,
            emptyText: 'Username'
        },
        {
            xtype: 'textfield',
            dock: 'top',
            flex: 1,
            itemId: 'password',
            id: 'password',
            margin: 10,
            fieldLabel: '',
            inputType: 'password',
            emptyText: 'Password'
        },
        {
            xtype: 'toolbar',
            modal: true,
            border: 3,
            dock: 'bottom',
            height: 56,
            shrinkWrap: 3,
            width: 400,
            trackMenus: false,
            layout: {
                type: 'hbox',
                pack: 'end'
            },
            items: [
                {
                    xtype: 'tbfill'
                },
                {
                    xtype: 'buttongroup',
                    border: false,
                    frame: false,
                    items: [
                        {
                            xtype: 'button',
                            modal: true,
                            itemId: 'resetLoginButton',
                            id: 'resetLoginButton',
                            scale: 'medium',
                            text: 'Reset'
                        },
                        {
                            xtype: 'button',
                            modal: true,
                            itemId: 'mybutton1',
                            enableToggle: true,
                            pressed: true,
                            scale: 'medium',
                            text: 'Login'
                        }
                    ]
                }
            ]
        }
    ]

});