import {getRepository} from 'typeorm'
import Buku from '../model/buku'

export default class SlotRepository{
    bukuRepository(){
        return getRepository(Buku)
    }

    // async findOne(id){
    //     const slot = await this.slotRepository().find({where:{id:id}})
    //     return slot
    // }

    async findAllBuku(){
        const buku = await this.bukuRepository().find()
        return buku
    }

    // async updateSlot(slot){
    //     return await this.slotRepository().save(slot)
    // }

    // async findAllparkingProduct(){
    //     const parking = await this.parkingRepository().find({relations:['product']})
    //     return parking
    // }

    // async createSlot(slot){
    //     return await this.slotRepository().save(slot)
    // }    
}