// const router=require('express').Router();

import express, { Router } from 'express';
import BukuRouter from './buku.route'
// import VehicleRouter from './vehicle.route'
// import TransactionRouter from './transaction.route'


export default express.Router()

.get('/',(req,res)=>{
    res.send('hello')
    })
.use('/buku',BukuRouter)
.use((req,res,next)=>{
        res.status(404).json({message:'Not Found.'});
    })

// .use('/vehicle',VehicleRouter)
// .use('/transaction',TransactionRouter)

// router.get('/',(req,res)=>{
//     console.log('hello')
// })

// router.use('/buku',BukuRouter)

