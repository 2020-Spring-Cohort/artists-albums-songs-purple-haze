
const createSingleAlbumElements = (album)=> {
    console.log(album);
    const songList = document.createElement('DIV');
    songList.classList.add('song-list');

    album.songs.forEach(song => {
    console.log(songs.songTitle)

    const singleAlbum = document.createElement('DIV');
    singleAlbum.classList.add('single-album');
    const albumName = document.createElement('H3');
    const albumPic = document.createElement('IMG');
    albumPic.src = `http://placekitten.com/250/250`;
    albumPic.classList.add('album-picture');

    singleAlbum.appendChild(albumPic);
    albumName.innerHTML = album.albumTitle;
    singleAlbum.appendChild(albumName);
    songList.appendChild(singleAlbum);

 });


const fetchAlbum = () => {
    fetch(`http://localhost:8080/artists/1/17`)
            .then(response => response.json())
            .then(singleAlbumInfo => createSingleAlbumElements(singleAlbumInfo))
};

        fetchArtist();

    