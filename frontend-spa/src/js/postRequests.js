import { addNewArtist,
    renderAllArtists,
    clearView

} from "./app.js";
export {
    addArtistToDataBase
}

const addArtistToDataBase = (jsonData) => {
    fetch ('http://localhost:8080/artists', {
    method: 'POST',
    headers : {
        'Content-Type' : 'application/json'
    },
    body: JSON.stringify(jsonData)
    }).then(clearView())
    .then(renderAllArtists());

}