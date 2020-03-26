export{displayAllAlbums
} 
import {
    renderSingleAlbum
}
from './app.js';



//get the json
const createAlbumsElements = (jsonData) => {
    console.log(jsonData);
    jsonData.forEach(album => {
        const anchor = document.querySelector('.anchor');
        const singleAlbum = document.createElement('SECTION');
        singleAlbum.classList.add('single-album');

        const albumList = document.createElement('DIV');
        albumList.classList.add('album-list');

        const albumPic = document.createElement('IMG');
        albumPic.src = `https://store.acousticsounds.com/images/medium/ALEG_23981__65677__03082010031341-4566.jpg`;
        albumPic.classList.add('album-picture');
        
        const albumTitle = document.createElement('H3');
        albumTitle.innerHTML = album.albumTitle;

        const artist = document.createElement('P');
        artist.innerHTML = album.artist;
        
        singleAlbum.style.cursor = 'pointer';
        singleAlbum.addEventListener('click', () =>{
            // console.log(album.id);
            renderSingleAlbum(album.id);
        })

       
        singleAlbum.appendChild(albumPic);
        singleAlbum.appendChild(albumTitle);
        singleAlbum.appendChild(artist);
        albumList.appendChild(singleAlbum);
        anchor.appendChild(albumList);
    });

};

const displayAllAlbums = () => {
    fetch(`http://localhost:8080/albums/`)
            .then(response => response.json())
            //.then(albumJson => console.log(albumJson))
            .then(albumInfo => createAlbumsElements(albumInfo))
}



