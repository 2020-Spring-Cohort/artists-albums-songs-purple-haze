import { addNewArtist,
    renderAllArtists,
    renderAllAlbums

} from "./app.js";
export {
    addArtistToDataBase,
    addSongToDataBase
}

const addArtistToDataBase = (jsonData) => {
    fetch ('http://localhost:8080/artists', {
    method: 'POST',
    headers : {
        'Content-Type' : 'application/json'
    },
    body: JSON.stringify(jsonData)
    }).then((jsonData)=> console.log(jsonData))
    .then(renderAllArtists());

}

const addSongToDataBase = (jsonData) => {
    fetch ('http://localhost:8080/songs', {
        method: 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify(jsonData)
    }).then((jsonData)=> console.log(jsonData))
      .then(renderAllAlbums());  
   
}

