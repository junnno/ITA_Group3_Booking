/*
 * File: app/store/CntrDetailsStore.js
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

Ext.define('Booking.store.CntrDetailsStore', {
    extend: 'Ext.data.Store',

    requires: [
        'Booking.model.CntrDetailsModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'CntrDetailsStore',
            model: 'Booking.model.CntrDetailsModel',
            data: [
                {
                    CntrNumber: 'alias',
                    CntrTypes: 'unde',
                    GrossWeight: 'eius',
                    NetWeight: 'quam',
                    CargoNature: 'perspiciatis',
                    CargoDescription: 'quia'
                },
                {
                    CntrNumber: 'esse',
                    CntrTypes: 'dolorem',
                    GrossWeight: 'aut',
                    NetWeight: 'vitae',
                    CargoNature: 'pariatur',
                    CargoDescription: 'tempore'
                }
            ]
        }, cfg)]);
    }
});