import postgres from 'pg'
import {createConnection} from 'typeorm'
import configure from '../config'
// import SlotSchema from '../entities/slot.schema'
// import VehicleSchema from '../entities/vehicle.schema'
// import LicenseStatusSchema from '../entities/licenseStatus.schema'
// import TransactionStatusSchema from '../entities/transactionStatus.schema'
// import TransactionSchema from '../entities/transaction.schema'
import BukuSchema from '../entities/buku.schema'

const {dbType,dbHost,dbPort,dbUser,dbPassword,dbName}=configure();
const createDbConnection = async ()=>{
    const connection = await createConnection({
        type: dbType || 'postgres',
        host: dbHost || 'localhost',
        port:dbPort || '5433',
        username: dbUser || 'postgres',
        password: dbPassword || 'sembarang1234',
        database : dbName ||'perpustakaan',
        entities: [BukuSchema] 
    });
    return connection;
}

export default createDbConnection;

