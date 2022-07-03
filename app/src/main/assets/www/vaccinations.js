import React, {useState} from "react";
import $ from 'jquery';
import "./form.css"
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import "./footer.css"

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});


function Vaccinations(){
    let sumDailydose1 = 0;
    let sumDailydose2 = 0;
    let sumDayTotal = 0;
    let sumTotalVaccinations=0;
    const classes = useStyles();

    const [firstDate, setFirstDate] = useState("");
    const [lastDate, setLastDate] = useState("");



    const handleFirstDateChange = (event) => {
        setFirstDate(event.target.value);
    };

    const handleLastDateChange = (event) => {
        setLastDate(event.target.value);
    };
    const handleSubmit = (event) => {
        event.preventDefault();
        const answer = window.confirm("Would you like to receive information within the following date?\n" +
            "From: " + firstDate +
            "\nTo: " + lastDate)
        let data = {
            date_from: firstDate,
            date_to: lastDate
        };
        if (answer) {
            $.when($.ajax({
                url: 'https://data.gov.gr/api/v1/query/mdg_emvolio',
                data: data,
                dataType: 'json',
                headers: {
                    "Authorization": "Token 7ed90049128c5ce939b1077baac37612e5e1dd63"
                },
                success: function (data){
                    let days=1;
                    document.getElementById('dailyTotalVaccinationsValue').innerHTML= "";
                    document.getElementById('firstDailyDosesValue').innerHTML="";
                    document.getElementById('secondDailyDosesValue').innerHTML="";
                    document.getElementById('totalVaccinationsValue').innerHTML="";
                    let i = 0;
                    let flag = false;
                    for(i=0; i<data.length; i++){
                        sumDailydose1 += data[i].dailydose1;
                        sumDailydose2 += data[i].dailydose2;
                        sumDayTotal += data[i].daytotal;
                        sumTotalVaccinations += data[i].totalvaccinations;
                        if(i%73===0 && flag===true){
                            document.getElementById('dailyTotalVaccinationsValue').innerHTML+= "\nDay :" + days + " " + sumDayTotal +"\t";
                            document.getElementById('firstDailyDosesValue').innerHTML+="\nDay :" + days + " " + sumDailydose1 +"\t";
                            document.getElementById('secondDailyDosesValue').innerHTML+="\nDay :" + days + " " + sumDailydose2 +"\t";
                            document.getElementById('totalVaccinationsValue').innerHTML+="\nDay :" + days + " " + sumTotalVaccinations +"\t";
                            days++;
                            sumDayTotal=0;
                            sumDailydose1=0;
                            sumDailydose2=0;
                            sumTotalVaccinations=0;
                        }
                        flag=true;
                    }
                }
            }));
        }
    }

    return(
        <div className="App">
            <div className="footer">Contact as at: 2132161000</div>
            <form onSubmit={handleSubmit}>
                <text>Enter starting date</text>
                <div className="form-control">
                    <input type="date"
                           name="firstDate"
                           placeholder="Enter starting date"
                           onChange={handleFirstDateChange}
                           value={firstDate}
                           required={true}/>
                </div>

                <text>Enter last date</text>

                <div className="form-control">
                    <input type="date"
                           name="LastName"
                           placeholder="Enter last date"
                           onChange={handleLastDateChange}
                           value={lastDate}
                           required={true}/>
                </div>
                <div className="form-control">
                    <label></label>
                    <button type="submit" > Submit </button>
                </div>
            </form>
            <TableContainer className="TableValue" component={Paper}>
                <Table className={classes.table} size="small" aria-label="a dense table">
                    <TableHead>
                        <TableRow>
                            <TableCell>Data</TableCell>
                            <TableCell align="right">Values</TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>daily total vaccinations</TableCell>
                            <TableCell id="dailyTotalVaccinationsValue" align="right"></TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>first daily doses</TableCell>
                            <TableCell id="firstDailyDosesValue" align="right"></TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>second daily doses</TableCell>
                            <TableCell id="secondDailyDosesValue" align="right"></TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>total vaccinations</TableCell>
                            <TableCell id="totalVaccinationsValue" align="right"></TableCell>
                        </TableRow>
                    </TableHead>
                </Table>
            </TableContainer>

        </div>

    );

}
export default Vaccinations;