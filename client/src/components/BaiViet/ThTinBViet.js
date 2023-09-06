import { Container, Image } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import MySpinner from "../../layout/MySpinner";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import "./BViet.scss";

const ThTinBViet = ({ baivietId }) => {
    const [thtinbviet, setThtinBviet] = useState(null);
    const { id } = useParams();

    useEffect(() => {
        const loadThtinBviet = async () => {
            let { data } = await  Apis.get(`${endpoints['thtin-bviet']} + ${id}`)
            setThtinBviet(data);

        }
        loadThtinBviet();

    });    

    if (!thtinbviet) {
        return <MySpinner />
    }

    return (
        <>
            <Container>
                <div className="thtinbviet">
                    <div className="thtin-col1">
                        <div className="thtin-anh">
                            <Image src={thtinbviet.hinhAnh} /> 
                        </div>
                        <div className="thtin-ndung">
                            <h3 className="bv-ten">{thtinbviet.tenBaiViet}</h3>
                            <p>Địa chỉ: {thtinbviet.diaChiCt}</p>
                            <div className="bv-3thongtin">
                                <p>Giá cho thuê: {thtinbviet.giaThue}</p>
                                <p>Diện tích phòng: {thtinbviet.dienTich}m2</p>
                                <p>#{thtinbviet.id}</p>
                            </div>
                            <div className="bv-mota">
                                <h4>Thông tin mô tả</h4>
                                <div className="mota">
                                    {thtinbviet.noiDung}
                                </div>
                            </div>
                            <div className="bv-dacdiemtin">
                                <h4>Đặc điểm tin đăng</h4>
                                <table>
                                    <tr>
                                        <th>Mã tin:</th>
                                        <td>#{thtinbviet.id}</td>
                                    </tr>
                                    <tr>
                                        <th>Khu vực cần tìm trọ:</th>
                                        <td>{thtinbviet.phamViCanTim}</td>
                                    </tr>
                                    <tr>
                                        <th>Ngày đăng:</th>
                                        <td>{thtinbviet.ngayDang}</td>
                                    </tr>
                                    <tr>
                                        <th>Ngày hết hạn:</th>
                                        <td>{thtinbviet.ngayDang}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div className="thtin-col2"></div>
                    <div className="thtin-col3">
                        <div className="thtin-tacgia">
                            <div className="tacgia-anh">
                                <center><Image roundedCircle src={thtinbviet.idNguoiDung.avatar} />  </center>

                            </div>
                            <div className="tacgia-thongtin">
                                <center>
                                    <h4>{thtinbviet.idNguoiDung.tenNguoiDung}</h4>

                                    <h5>{thtinbviet.idNguoiDung.sdt}</h5>
                                </center>
                            </div>

                        </div>

                    </div>

                </div>

            </Container>


        </>

    );
}

export default ThTinBViet;