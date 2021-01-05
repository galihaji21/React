import BukuRepository from '../repository/buku.repository'


export default class BukuService {
    // async getSlotById(id) {
    //     return await new SlotRepository().findOne(id);
    // }

    // async createSlot(amount) {
    //     var slots=[]
    //     for(var i = 0;i<amount;i++){
    //         const slot={    
    //             "slotId": "SLOT"+(i+1),
    //             "slotStatus": {
    //                 "id": 1,
    //                 "status": "empty"
    //             }
    //         }
    //         slots= [...slots, slot]
    //         await new SlotRepository().createSlot(slot)
    //     }
    //     return slots
    // }

    async getAllBuku() {
        return await new BukuRepository().findAllBuku()
    }
   
    // async updateSlot(slot){
    //     return await new SlotRepository().updateSlot(slot)
    // }
}