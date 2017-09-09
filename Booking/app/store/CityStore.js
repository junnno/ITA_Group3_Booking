/*
 * File: app/store/CityStore.js
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

Ext.define('Booking.store.CityStore', {
    extend: 'Ext.data.Store',

    requires: [
        'Booking.model.CityModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Array'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'CityStore',
            model: 'Booking.model.CityModel',
            data: [
                {
                    name: 'Hong Kong',
                    code: 'HKG'
                },
                {
                    name: 'Long Beach',
                    code: 'LGB'
                },
                {
                    name: 'Manila',
                    code: 'MNL'
                },
                {
                    name: 'Singapore',
                    code: 'SIN'
                },
                {
                    name: 'Busan',
                    code: 'PUS'
                },
                {
                    name: 'Rotterdam',
                    code: 'RTM'
                }
            ],
            proxy: {
                type: 'ajax',
                reader: {
                    type: 'array'
                }
            }
        }, cfg)]);
    }
});