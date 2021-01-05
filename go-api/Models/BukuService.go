package Models

import (
	_ "github.com/go-sql-driver/mysql"
	"perpus.com/m/Config"
)

//GetAllBook Fetch all book data
func GetAllBooks(buku *[]Buku) (err error) {
	if err = Config.DB.Find(buku).Error; err != nil {
		return err
	} else {
		return nil
	}

}

//CreateUser ... Insert New data
func CreateBook(Buku *Buku) (err error) {
	if err = Config.DB.Create(Buku).Error; err != nil {
		return err
	}
	return nil
}

//GetUserByID ... Fetch only one user by Id
func GetBookByID(Buku *Buku, id string) (err error) {
	if err = Config.DB.Where("id = ?", id).First(Buku).Error; err != nil {
		return err
	}
	return nil
}
