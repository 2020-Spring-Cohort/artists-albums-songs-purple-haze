
const createSingleAlbumElements = (album)=> {
    console.log(album);
    const songList = document.createElement('DIV');
    albumList.classList.add('album-list');

    album.songs.forEach(song => {
    console.log(songs.songTitle)

    const singleAlbum = document.createElement('DIV');
    singleAlbum.classList.add('single-album');
    const albumPic = document.createElement('IMG');
    const albumName = document.createElement('H3');
    const artist = document.createElement('H3');
    albumPic.src = `http://placekitten.com/250/250`;
    albumPic.classList.add('album-picture');
    
        
    singleAlbum.appendChild(albumPic);
    albumName.innerHTML = album.albumTitle;
    artist.innerHTML = album.name;
    singleAlbum.appendChild(albumName);
    albumList.appendChild(singleAlbum);

 });

    const anchor = document.querySelector('.anchor');
    const songSection = document.createElement('DIV');

    const songTitle = document.createElement('H3');
    songTitle.innerHTML = album.songTitle;

    anchor.appendChild(songSection);
    anchor.appendChild(albumList);
    songSection.appendChild(songTitle);

}

const fetchAlbum = () => {
    fetch(`http://localhost:8080/artists/1/17`)
            .then(response => response.json())
            .then(singleAlbumInfo => createSingleAlbumElements(singleAlbumInfo))
};

        fetchArtist();

    