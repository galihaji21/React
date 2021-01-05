package Models

type Buku struct {
	Id        int64  `json:"id"`
	Nama_Buku string `json:"namaBuku"`
	Penulis   string `json:"penulis"`
	Eksemplar uint   `json:"eksemplar"`
}

func (b *Buku) TableName() string {
	return "buku"
}
