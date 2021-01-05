package main

import (
	"fmt"

	"github.com/jinzhu/gorm"
	"perpus.com/m/Config"
	"perpus.com/m/Models"
	"perpus.com/m/Routes"
)

var err error

func main() {
	Config.DB, err = gorm.Open("mysql", Config.DbURL(Config.BuildDBConfig()))
	if err != nil {
		fmt.Println("Status:", err)
	}
	defer Config.DB.Close()
	Config.DB.AutoMigrate(&Models.Buku{})

	r := Routes.SetupRouter()
	//running
	r.Run()
}
