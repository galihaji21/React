import {EntitySchema} from 'typeorm';
import Buku from '../model/buku'

const BukuSchema = new EntitySchema({
    name:'Buku',
    target:Buku,
    tableName: 'buku',
    columns:{
        id:{
            name:'Id',
            primary: true,
            type:'int',
            generated:true
        },
        namaBuku:{
            name:'Nama_Buku',
            type: 'char'
        },
        ekspemlar:{
            name:'Eksemplar',
            type: 'int'
        },
        penulis:{
            name:'Penulis',
            type:'char'
        }
    }
})

export default BukuSchema;