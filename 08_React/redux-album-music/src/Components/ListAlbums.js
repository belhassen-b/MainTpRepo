import {useEffect , useState} from "react";
import CardAlbumDisplay from "./CardItem/CardAlbumDisplay";

const ListAlbums = (props) => {


    useEffect(() => {
            console.log(props.albums);
        }
    , [])

    return (
   <div className="row row-cols-1 row-cols-md-3 g-4">
            {
                // eslint-disable-next-line array-callback-return
                props.albums.map((album, index) => {
                    return <CardAlbumDisplay key={index} album={album}/>
                })
            }

        </div>
    )
}
export default ListAlbums