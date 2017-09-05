/*
 * File: app/view/MyContainer7.js
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

Ext.define('Booking.view.MyContainer7', {
    extend: 'Ext.container.Container',
    alias: 'widget.mycontainer7',

    requires: [
        'Booking.view.MyContainer7ViewModel',
        'Ext.Img',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Fill',
        'Ext.container.ButtonGroup',
        'Ext.button.Button'
    ],

    viewModel: {
        type: 'mycontainer7'
    },

    items: [
        {
            xtype: 'image',
            flex: 1,
            height: 160,
            width: 201,
            src: 'brand.png'
        },
        {
            xtype: 'textfield',
            flex: 1,
            itemId: 'username',
            margin: 10,
            emptyText: 'Username'
        },
        {
            xtype: 'textfield',
            flex: 1,
            itemId: 'password',
            margin: 10,
            fieldLabel: '',
            inputType: 'password',
            emptyText: 'Password'
        },
        {
            xtype: 'toolbar',
            modal: true,
            border: 3,
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
                            itemId: 'mybutton',
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