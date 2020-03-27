import { addNewArtist,
    renderAllArtists,
    renderAllAlbums,
    clearView

} from "./app.js";

import {
    displaySingleAlbum
} from "./albumBuilder.js";


export {
    addArtistToDataBase,
    addSongToDataBase
}

const addArtistToDataBase = async (jsonData) => {
    await fetch ('http://localhost:8080/artists', {
    method: 'POST',
    headers : {
        'Content-Type' : 'application/json'
    },
    body: JSON.stringify(jsonData)
    }).then(clearView())
    .then(renderAllArtists());

}

const addSongToDataBase = async (jsonData, albumId) => { 
    await fetch ('http://localhost:8080/albums/' + albumId, {
        method: 'PATCH',
        headers : {
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify(jsonData)
    }).then (clearView())
    .then (displaySingleAlbum(albumId));  
   
}

