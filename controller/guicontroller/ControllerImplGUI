package controller.guicontroller;

import model.PortfolioFlexible;
import view.guiview.buttons.ButtonsView;
import view.guiview.buttons.FlexibleAllOptions;
import view.guiview.buttons.PortfolioPerformanceAll;
import view.guiview.buttons.UpdatePortfolio;
import view.guiview.buttons.CostBasisOption;
import view.guiview.buttons.CreatePortfolioOptionsFlexible;
import view.guiview.charts.BarGraphImpl;
import view.guiview.fileselection.IFileSelection;
import view.guiview.fileselection.FileSelect;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import view.guiview.helperclass.HelperClass;
import view.guiview.textfield.DCASubPanelEqualWeightWithEndDate;
import view.guiview.textfield.DCASubPanelEqualWeights;
import view.guiview.textfield.DCAWithEndDateEqualWeight;
import view.guiview.textfield.DCAWithoutEndDateEqualWeight;
import view.guiview.textfield.TextFieldView;
import view.guiview.textfield.BuyStocks;
import view.guiview.textfield.CostBasisWithCommissionPan;
import view.guiview.textfield.CostBasisWithoutCommissionPan;
import view.guiview.textfield.CreatePortfolioManuallyPanel;
import view.guiview.textfield.UpdatePortDCA;
import view.guiview.textfield.DCASubPanelWithEndDate;
import view.guiview.textfield.DCASubPanelWoEndDate;
import view.guiview.textfield.DCAWithoutEndDateMainPan;
import view.guiview.textfield.GetCompositionPanel;
import view.guiview.textfield.DCAWithEndDateMainPan;
import view.guiview.textfield.GetPortfolioId;
import view.guiview.textfield.PortfolioValPan;
import view.guiview.textfield.PortfolioPerformancePanel;
import view.guiview.textfield.SellStocksPanel;
import view.guiview.textfield.UpdatePortDCAStrategy;

import javax.swing.JFrame;
import javax.swing.JFileChooser;


/**
 * This is ControllerImplGUI Class for the implementation of
 * ControllerMainGUI Interface. Methods mentioned in the
 * ControllerImplGUI class helps in interaction between Model and View.
 **/

public class ControllerImplGUI implements ControllerMainGUI, ActionListener {


  private final TextFieldView view;
  private final PortfolioFlexible newModel;
  private String str;
  private Map<String, Runnable> actionMap;

  private int userId;
  private String userName;
  private String userEmail;

  private ButtonsView getAllOptions;
  private JFrame frame;
  private ButtonsView getAllOptionsToCreate;
  private TextFieldView createPortManuallyPan;
  private TextFieldView buyStocksPan;
  private TextFieldView getCompositionPan;
  private TextFieldView sellStockPan;
  private TextFieldView dollarCostAverageWEndDatePan;
  private TextFieldView dollarCostAverageWOEndDatePan;

  private TextFieldView dollarCostAverageSubPanWEndDate;
  private TextFieldView dollarCostAverageSubPanWOEndDate;
  private TextFieldView updateSubPanel;

  private ButtonsView chooseCostBasis;

  private ButtonsView ppVar;

  private TextFieldView dollarCostAverageSubPanWOEndDate1;
  private TextFieldView dollarCostAverageWOEndDatePan1;

  private TextFieldView dollarCostAverageWEndDatePan1;
  private TextFieldView dollarCostAverageSubPanWEndDate1;


  private TextFieldView costBasisWithCommission;

  private TextFieldView costBasisWithoutCommission;
  private TextFieldView portValPan;
  private IFileSelection getFileSelectionPan;

  private TextFieldView getPortfolioPan;
  private TextFieldView getPortPerPanel;
  private ButtonsView updateOption;
  private TextFieldView updatePortDCALogic;


  /**
   * This is the constructor for ControllerImplGUI class
   * which initializes newModel and view.
   *
   * @param newModel PortfolioFlexible, contains newModel
   * @param view     TextFieldView , contains view
   **/


  public ControllerImplGUI(PortfolioFlexible newModel, TextFieldView view) {
    this.newModel = newModel;
    this.view = view;
    view.addActionListener(this);
    str = "";
  }


  @Override
  public void goStock()
      throws InterruptedException {
    actionMap = initializeMap();
  }

  private Map<String, Runnable> initializeMap() {
    Map<String, Runnable> actionMap = new HashMap<>();
    actionMap.put("next", () -> {
      boolean check = HelperClass.checkUserInputs(view);
      if (check) {
        userId = Integer.valueOf(view.getInput().get(0));
        userName = view.getInput().get(1);
        userEmail = view.getInput().get(2);
        view.clearField();
        getAllOptions = new FlexibleAllOptions();
        HelperClass.disposeTheSecondGetFirstBT(getAllOptions, view, this);
      }
    });

    actionMap.put("createPortfolio", () -> {
      getAllOptionsToCreate = new CreatePortfolioOptionsFlexible();
      HelperClass.disposeTheSecondSetFirstViewBB(getAllOptionsToCreate, getAllOptions, this);
    });

    actionMap.put("homeCreatePortAll", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondSetFirstViewBB(getAllOptions, getAllOptionsToCreate, this);
    });

    actionMap.put("createPortByInput", () -> {
      createPortManuallyPan = new CreatePortfolioManuallyPanel();
      HelperClass.disposeTheSecondSetFirstView(createPortManuallyPan, getAllOptionsToCreate, this);
    });

    actionMap.put("addMoreButton", () -> {
      boolean check = HelperClass.checkStockShareDate(createPortManuallyPan);
      if (check) {
        int portfolioId = Integer.valueOf(createPortManuallyPan.getInput().get(0));
        String tickerNumber = createPortManuallyPan.getInput().get(1);
        int numberOfStocks = Integer.valueOf(createPortManuallyPan.getInput().get(2));
        String inputDate = createPortManuallyPan.getInput().get(3);
        ArrayList<String> tickerNumData = new ArrayList<>();
        tickerNumData.add(tickerNumber);
        tickerNumData.add(String.valueOf(numberOfStocks));
        tickerNumData.add(inputDate);
        String message = "";
        try {
          StringBuilder messageSb = newModel.addPortfolioByManualInput(userId, userName,
              userEmail, portfolioId, tickerNumData);
          message = messageSb.toString();
        } catch (IllegalArgumentException | InterruptedException | ParseException
                 | IOException e) {
          message = e.getMessage();
        }
        createPortManuallyPan.clearField();
        createPortManuallyPan.errorMessage(message);
      } else {
        createPortManuallyPan.clearField();
      }
    });

    actionMap.put("homeCreatePortManually", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondSetFirstView(createPortManuallyPan, getAllOptionsToCreate, this);
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, createPortManuallyPan, this);
    });


    actionMap.put("buyStocks", () -> {
      updateOption = new UpdatePortfolio();
      HelperClass.disposeTheSecondSetFirstViewBB(updateOption, getAllOptions, this);
    });

    actionMap.put("homeBuyMain", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondSetFirstViewBB(getAllOptions, updateOption, this);
    });


    actionMap.put("normalUpdate", () -> {
      buyStocksPan = new BuyStocks();
      HelperClass.disposeTheSecondSetFirstView(buyStocksPan, updateOption, this);
    });


    actionMap.put("buyMoreStock", () -> {
      boolean check = HelperClass.checkStockShareDate(buyStocksPan);
      if (check) {
        int portfolioId = Integer.valueOf(buyStocksPan.getInput().get(0));
        String tickerNumber = buyStocksPan.getInput().get(1);
        int numberOfStocks = Integer.valueOf(buyStocksPan.getInput().get(2));
        String inputDate = buyStocksPan.getInput().get(3);
        ArrayList<String> tickerNumData = new ArrayList<>();
        tickerNumData.add(tickerNumber);
        tickerNumData.add(String.valueOf(numberOfStocks));
        tickerNumData.add(inputDate);
        String message = "";
        try {
          StringBuilder messageSb = newModel.modifyPortfolioByAdding(userId, userName,
              userEmail, portfolioId, tickerNumData);
          message = messageSb.toString();
        } catch (IllegalArgumentException | InterruptedException | ParseException | IOException e) {
          message = e.getMessage();
        }
        buyStocksPan.clearField();
        buyStocksPan.errorMessage(message);
      } else {
        buyStocksPan.clearField();
      }
    });

    actionMap.put("homeBuyStocks", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, buyStocksPan, this);
      // helperClass.disposeTheFirstSetSecond(getAllOptions, view , this);
    });


    actionMap.put("withDCSWithEnDate", () -> {
      dollarCostAverageWEndDatePan = new DCAWithEndDateMainPan();
      HelperClass.disposeTheSecondSetFirstView(dollarCostAverageWEndDatePan, updateOption, this);
    });

    actionMap.put("withDCSWOEnDate", () -> {
      dollarCostAverageWOEndDatePan = new DCAWithoutEndDateMainPan();
      HelperClass.disposeTheSecondSetFirstView(dollarCostAverageWOEndDatePan, updateOption, this);
    });


    actionMap.put("withWeightOnSpecificDate", () -> {
      updatePortDCALogic = new UpdatePortDCAStrategy();
      HelperClass.disposeTheSecondSetFirstView(updatePortDCALogic, updateOption, this);
    });

    actionMap.put("homeDCASpecificDateStrategy", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, updatePortDCALogic, this);
    });

    actionMap.put("updateStocksDCA", () -> {
      boolean check = HelperClass.checkDCAPanDataWO(updatePortDCALogic);
      if (check) {
        int numOfStocks = Integer.valueOf(updatePortDCALogic.getInput().get(3));
        updateSubPanel = new UpdatePortDCA(numOfStocks);
        //    updateSubPanel.addActionListener(this);
        HelperClass.disposeTheFirstSetSecondTT(updateSubPanel, updatePortDCALogic, this);
      }
    });

    actionMap.put("updatePortDCAWO", () -> {
      boolean check = HelperClass.checkTickerPercentDCA(updateSubPanel);
      if (check) {
        int portfolioId = Integer.valueOf(updatePortDCALogic.getInput().get(0));
        Double amount = Double.valueOf(updatePortDCALogic.getInput().get(1));
        // int interval = Integer.valueOf(updateSubPanel.getInput().get(2));
        String startDate = updatePortDCALogic.getInput().get(2);
        //String endDate = dollarCostAverageWOEndDatePan.getInput().get(4);
        ArrayList<String> inputList = updateSubPanel.getInput();
        String message = "";
        try {
          StringBuilder messageSb = newModel.createPortfolioInvestment(userId, userName,
              userEmail, portfolioId, inputList, amount, startDate);
          updateSubPanel.hideMainButton();
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        updateSubPanel.clearField();
        updatePortDCALogic.clearField();
        updateSubPanel.errorMessage(message);
      } else {
        updateSubPanel.clearField();
        updatePortDCALogic.clearField();
      }
      // helperClass.disposeTheFirstSetSecondTT(updatePortDCALogic, updateSubPanel , this);
    });

    actionMap.put("homeUpdatePort", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, updateSubPanel, this);
    });


    actionMap.put("getComposition", () -> {
      getCompositionPan = new GetCompositionPanel();
      //  getCompositionPan.addActionListener(this);
      //  helperClass.disposeTheSecondSetFirstView(view, getAllOptions, this);
      HelperClass.disposeTheSecondSetFirstView(getCompositionPan, getAllOptions, this);
    });

    actionMap.put("getCompositionButton", () -> {

      boolean check = HelperClass.checkGetCompositionInput(getCompositionPan);
      if (check) {
        int portfolioId = Integer.valueOf(getCompositionPan.getInput().get(0));
        String inputDate = getCompositionPan.getInput().get(1);
        String message = "";
        try {
          StringBuilder messageSb = newModel.getComposition(userId, userName,
              userEmail, portfolioId, inputDate);
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException e) {
          message = e.getMessage();
        }
        getCompositionPan.clearField();
        getCompositionPan.errorMessage(message);
      } else {
        getCompositionPan.clearField();
      }
    });

    actionMap.put("homeGetComposition", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, getCompositionPan, this);
    });

    actionMap.put("sellStocks", () -> {
      sellStockPan = new SellStocksPanel();
      HelperClass.disposeTheSecondSetFirstView(sellStockPan, getAllOptions, this);
    });


    actionMap.put("sellMoreStock", () -> {
      boolean check = HelperClass.checkStockShareDate(sellStockPan);
      if (check) {
        int portfolioId = Integer.valueOf(sellStockPan.getInput().get(0));
        String tickerNumber = sellStockPan.getInput().get(1);
        int numberOfStocks = Integer.valueOf(sellStockPan.getInput().get(2));
        String inputDate = sellStockPan.getInput().get(3);

        String message = "";
        try {
          StringBuilder messageSb = newModel.sellStocks(userId, userName,
              userEmail, portfolioId, tickerNumber, numberOfStocks, inputDate);
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        sellStockPan.clearField();
        sellStockPan.errorMessage(message);
      } else {
        sellStockPan.clearField();
      }
    });

    actionMap.put("homeSellStocks", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, sellStockPan, this);
    });


    actionMap.put("portfolioValue", () -> {
      portValPan = new PortfolioValPan();
      HelperClass.disposeTheSecondSetFirstView(portValPan, getAllOptions, this);
    });

    actionMap.put("getVal", () -> {
      boolean check = HelperClass.checkGetCompositionInput(portValPan);
      if (check) {
        int portfolioId = Integer.valueOf(portValPan.getInput().get(0));
        String inputDate = portValPan.getInput().get(1);
        String message = "";

        try {
          StringBuilder messageSb = newModel.portfolioValue(userId, userName,
              userEmail, portfolioId, inputDate);
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException | InterruptedException e) {
          message = e.getMessage();
        }
        portValPan.clearField();
        portValPan.errorMessage(message);
      } else {
        portValPan.clearField();
      }
    });

    actionMap.put("homePortVal", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, portValPan, this);
    });


    actionMap.put("costBasis", () -> {
      chooseCostBasis = new CostBasisOption();
      HelperClass.disposeTheSecondSetFirstViewBB(chooseCostBasis, getAllOptions, this);
    });

    actionMap.put("homeCostBasisMain", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondSetFirstViewBB(getAllOptions, chooseCostBasis, this);
    });


    actionMap.put("withCommission", () -> {
      costBasisWithCommission = new CostBasisWithCommissionPan();
      HelperClass.disposeTheSecondSetFirstView(costBasisWithCommission, chooseCostBasis, this);
    });

    actionMap.put("homeCostBasisWithComm", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, costBasisWithCommission, this);
    });

    actionMap.put("withoutCommission", () -> {
      costBasisWithoutCommission = new CostBasisWithoutCommissionPan();
      // costBasisWithoutCommission.addActionListener(this);
      HelperClass.disposeTheSecondSetFirstView(costBasisWithoutCommission, chooseCostBasis, this);
    });

    actionMap.put("homeCostBasisWithoutComm", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, costBasisWithoutCommission, this);
    });


    actionMap.put("getCostBasisW", () -> {
      boolean check = HelperClass.checkCommissionFee(costBasisWithCommission);
      if (check) {
        int portfolioId = Integer.valueOf(costBasisWithCommission.getInput().get(0));
        String inputDate = costBasisWithCommission.getInput().get(1);
        Double commissionFee = Double.valueOf(costBasisWithCommission.getInput().get(2));
        String message = "";

        try {
          StringBuilder messageSb = newModel.getCostBasis(userId, userName,
              userEmail, portfolioId, inputDate, commissionFee);
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        costBasisWithCommission.clearField();
        costBasisWithCommission.errorMessage(message);
      } else {
        costBasisWithCommission.clearField();
      }
    });

    actionMap.put("getCostBasisWO", () -> {
      boolean check = HelperClass.checkCommissionFeeWo(costBasisWithoutCommission);
      if (check) {
        int portfolioId = Integer.valueOf(costBasisWithoutCommission.getInput().get(0));
        String inputDate = costBasisWithoutCommission.getInput().get(1);
        String message = "";
        try {
          StringBuilder messageSb = newModel.getCostBasis(userId, userName,
              userEmail, portfolioId, inputDate, 0.00);
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        costBasisWithoutCommission.clearField();
        costBasisWithoutCommission.errorMessage(message);
      } else {
        costBasisWithoutCommission.clearField();
      }
    });

    actionMap.put("createPortDCSWEndDate", () -> {
      dollarCostAverageWEndDatePan = new DCAWithEndDateMainPan();
      HelperClass.disposeTheSecondSetFirstView(dollarCostAverageWEndDatePan,
          getAllOptionsToCreate,
          this);
    });

    actionMap.put("homeCreateDCAWithEnd", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, dollarCostAverageWEndDatePan, this);
    });

    actionMap.put("addDollarCostW", () -> {
      boolean check = HelperClass.checkDCAPanData(dollarCostAverageWEndDatePan);
      if (check) {
        int numOfStocks = Integer.valueOf(dollarCostAverageWEndDatePan.getInput().get(5));
        dollarCostAverageSubPanWEndDate = new DCASubPanelWithEndDate(numOfStocks);
        HelperClass.disposeTheSecondSetFirstViewTT(dollarCostAverageSubPanWEndDate,
            dollarCostAverageWEndDatePan, this);
      }
    });

    actionMap.put("createPortDCAW", () -> {
      boolean check = HelperClass.checkTickerPercentDCA(dollarCostAverageSubPanWEndDate);
      if (check) {
        int portfolioId = Integer.valueOf(dollarCostAverageWEndDatePan.getInput().get(0));
        Double amount = Double.valueOf(dollarCostAverageWEndDatePan.getInput().get(1));
        int interval = Integer.valueOf(dollarCostAverageWEndDatePan.getInput().get(2));
        String startDate = dollarCostAverageWEndDatePan.getInput().get(3);
        String endDate = dollarCostAverageWEndDatePan.getInput().get(4);
        ArrayList<String> inputList = dollarCostAverageSubPanWEndDate.getInput();
        String message = "";
        try {
          StringBuilder messageSb = newModel.createPortfolioDollarAverageLogicWithEndDate(
              userId, userName,
              userEmail, portfolioId, inputList, amount, interval, startDate, endDate);
          message = messageSb.toString();
          dollarCostAverageSubPanWEndDate.hideMainButton();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        dollarCostAverageSubPanWEndDate.clearField();
        dollarCostAverageWEndDatePan.clearField();
        // dollarCostAverageSubPanWEndDate.errorMessage(message);
        dollarCostAverageSubPanWEndDate.errorMessage(message);
      } else {
        dollarCostAverageSubPanWEndDate.clearField();
        dollarCostAverageWEndDatePan.clearField();
      }

    });

    actionMap.put("homeCreateSubDCAWithEnd", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions,
          dollarCostAverageSubPanWEndDate, this);
    });


    // Without end date

    actionMap.put("createPortDCSWOEndDate", () -> {
      dollarCostAverageWOEndDatePan = new DCAWithoutEndDateMainPan();
      HelperClass.disposeTheSecondSetFirstView(dollarCostAverageWOEndDatePan,
          getAllOptionsToCreate,
          this);
    });

    actionMap.put("homeCreateDCAWOEnd", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions,
          dollarCostAverageWOEndDatePan, this);
    });

    actionMap.put("addDollarCostWO", () -> {
      boolean check = HelperClass.checkDCAPanData(dollarCostAverageWOEndDatePan);
      if (check) {
        int numOfStocks = Integer.valueOf(dollarCostAverageWOEndDatePan.getInput().get(5));
        dollarCostAverageSubPanWOEndDate = new DCASubPanelWoEndDate(numOfStocks);
        HelperClass.disposeTheSecondSetFirstViewTT(dollarCostAverageSubPanWOEndDate,
            dollarCostAverageWOEndDatePan, this);
      }
    });

    actionMap.put("createPortDCAWO", () -> {
      boolean check = HelperClass.checkTickerPercentDCA(dollarCostAverageSubPanWOEndDate);
      if (check) {
        int portfolioId = Integer.valueOf(dollarCostAverageWOEndDatePan.getInput().get(0));
        Double amount = Double.valueOf(dollarCostAverageWOEndDatePan.getInput().get(1));
        int interval = Integer.valueOf(dollarCostAverageWOEndDatePan.getInput().get(2));
        String startDate = dollarCostAverageWOEndDatePan.getInput().get(3);
        String endDate = dollarCostAverageWOEndDatePan.getInput().get(4);
        ArrayList<String> inputList = dollarCostAverageSubPanWOEndDate.getInput();
        String message = "";
        try {
          StringBuilder messageSb = newModel.createPortfolioDollarAverageLogicWithEndDate(userId,
              userName,
              userEmail, portfolioId, inputList, amount, interval, startDate, endDate);
          dollarCostAverageSubPanWOEndDate.hideMainButton();
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        dollarCostAverageSubPanWOEndDate.clearField();
        //dollarCostAverageWOEndDatePan.clearField();
        dollarCostAverageSubPanWOEndDate.errorMessage(message);
        //dollarCostAverageWOEndDatePan.errorMessage(message);

      } else {
        dollarCostAverageSubPanWOEndDate.clearField();
        // dollarCostAverageWOEndDatePan.clearField();
      }
    });

    actionMap.put("homeCreateSubDCAWOEnd", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions,
          dollarCostAverageSubPanWOEndDate, this);
    });


    // From here


    actionMap.put("createPortDCSWOEndDateEw", () -> {
      dollarCostAverageWOEndDatePan1 = new DCAWithoutEndDateEqualWeight();
      HelperClass.disposeTheSecondSetFirstView(dollarCostAverageWOEndDatePan1,
          getAllOptionsToCreate,
          this);
    });

    actionMap.put("homeEqualWithout", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, dollarCostAverageWOEndDatePan1, this);
    });

    actionMap.put("addDCAEqualWo", () -> {
      boolean check = HelperClass.checkDCAPanData(dollarCostAverageWOEndDatePan1);
      if (check) {
        int numOfStocks = Integer.valueOf(dollarCostAverageWOEndDatePan1.getInput().get(5));
        dollarCostAverageSubPanWOEndDate1 = new DCASubPanelEqualWeights(numOfStocks);
        HelperClass.disposeTheSecondSetFirstViewTT(dollarCostAverageSubPanWOEndDate1,
            dollarCostAverageWOEndDatePan1, this);
      }
    });

    actionMap.put("createPortEqualWeight", () -> {
      boolean check = HelperClass.checkTickerPercentDCAEw(dollarCostAverageSubPanWOEndDate1);
      if (check) {
        int portfolioId = Integer.valueOf(dollarCostAverageWOEndDatePan1.getInput().get(0));
        Double amount = Double.valueOf(dollarCostAverageWOEndDatePan1.getInput().get(1));
        int interval = Integer.valueOf(dollarCostAverageWOEndDatePan1.getInput().get(2));
        String startDate = dollarCostAverageWOEndDatePan1.getInput().get(3);
        String endDate = dollarCostAverageWOEndDatePan1.getInput().get(4);
        int numOfStocks = Integer.valueOf(dollarCostAverageWOEndDatePan1.getInput().get(5));
        ArrayList<String> inputList = dollarCostAverageSubPanWOEndDate1.getInput();
        ArrayList<String> inputListFinal = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
          inputListFinal.add(inputList.get(i));
          inputListFinal.add(String.valueOf(100.00 / numOfStocks));
        }
        String message = "";
        try {
          StringBuilder messageSb = newModel.createPortfolioDollarAverageLogicWithEndDate(userId,
              userName,
              userEmail, portfolioId, inputListFinal, amount, interval, startDate, endDate);
          dollarCostAverageSubPanWOEndDate1.hideMainButton();
          message = messageSb.toString();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        dollarCostAverageSubPanWOEndDate1.clearField();
        //dollarCostAverageWOEndDatePan.clearField();
        dollarCostAverageSubPanWOEndDate1.errorMessage(message);
        //dollarCostAverageWOEndDatePan.errorMessage(message);

      } else {
        dollarCostAverageSubPanWOEndDate1.clearField();
        // dollarCostAverageWOEndDatePan.clearField();
      }
    });


    actionMap.put("homeEqualWeight", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions,
          dollarCostAverageSubPanWOEndDate1, this);
    });


    // New With End date

    actionMap.put("createPortDCSWEndDateEw", () -> {
      dollarCostAverageWEndDatePan1 = new DCAWithEndDateEqualWeight();
      HelperClass.disposeTheSecondSetFirstView(dollarCostAverageWEndDatePan1,
          getAllOptionsToCreate,
          this);
    });

    actionMap.put("homeEqualWith1", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions,
          dollarCostAverageWEndDatePan1, this);
    });

    actionMap.put("addDCAEqualWith", () -> {
      boolean check = HelperClass.checkDCAPanData(dollarCostAverageWEndDatePan1);
      if (check) {
        int numOfStocks = Integer.valueOf(dollarCostAverageWEndDatePan1.getInput().get(5));
        dollarCostAverageSubPanWEndDate1 = new DCASubPanelEqualWeightWithEndDate(numOfStocks);
        HelperClass.disposeTheSecondSetFirstViewTT(dollarCostAverageSubPanWEndDate1,
            dollarCostAverageWEndDatePan1, this);
      }
    });

    actionMap.put("createPortEqualWeightWith", () -> {
      boolean check = HelperClass.checkTickerPercentDCAEw(dollarCostAverageSubPanWEndDate1);
      if (check) {
        int portfolioId = Integer.valueOf(dollarCostAverageWEndDatePan1.getInput().get(0));
        Double amount = Double.valueOf(dollarCostAverageWEndDatePan1.getInput().get(1));
        int interval = Integer.valueOf(dollarCostAverageWEndDatePan1.getInput().get(2));
        String startDate = dollarCostAverageWEndDatePan1.getInput().get(3);
        String endDate = dollarCostAverageWEndDatePan1.getInput().get(4);
        int numOfStocks = Integer.valueOf(dollarCostAverageWEndDatePan1.getInput().get(5));
        ArrayList<String> inputList = dollarCostAverageSubPanWEndDate1.getInput();
        ArrayList<String> inputListFinal = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
          inputListFinal.add(inputList.get(i));
          inputListFinal.add(String.valueOf(100.00 / numOfStocks));
        }
        String message = "";
        try {
          StringBuilder messageSb = newModel.createPortfolioDollarAverageLogicWithEndDate(userId,
              userName,
              userEmail, portfolioId, inputListFinal, amount, interval, startDate, endDate);
          message = messageSb.toString();
          dollarCostAverageSubPanWEndDate1.hideMainButton();
        } catch (IllegalArgumentException | IOException | ParseException e) {
          message = e.getMessage();
        }
        dollarCostAverageSubPanWEndDate1.clearField();
        dollarCostAverageWEndDatePan1.clearField();
        // dollarCostAverageSubPanWEndDate.errorMessage(message);
        dollarCostAverageSubPanWEndDate1.errorMessage(message);
      } else {
        dollarCostAverageSubPanWEndDate1.clearField();
        dollarCostAverageWEndDatePan1.clearField();
      }

    });

    actionMap.put("homeEqualWeightWith", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, dollarCostAverageSubPanWEndDate1, this);
    });


    actionMap.put("createPortThroughFile", () -> {
      getPortfolioPan = new GetPortfolioId();
      HelperClass.disposeTheSecondSetFirstView(getPortfolioPan, getAllOptionsToCreate, this);
    });

    actionMap.put("homeGetFiles", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, getPortfolioPan, this);
    });

    actionMap.put("selectFilePathNow", () -> {
      boolean check = HelperClass.checkPortfolioId(getPortfolioPan);
      if (check) {
        getFileSelectionPan = new FileSelect();
        HelperClass.disposeTheSecondSetFirstViewFS(getFileSelectionPan,
            getPortfolioPan, this);
      }
    });

    actionMap.put("homeFileSelect", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheFirstSetSecondViewFS(getAllOptions, getFileSelectionPan, this);
    });

    actionMap.put("done", () -> {
      String fileName = "";
      if (getFileSelectionPan.getFileChooser() == JFileChooser.APPROVE_OPTION) {
        fileName = getFileSelectionPan.getInput();
        try {
          StringBuilder sb = newModel.addPortfolioByFile(userId, userName, userEmail,
              Integer.valueOf(getPortfolioPan.getInput().get(0)), fileName);
          String message = sb.toString();
          getFileSelectionPan.setHint(message);
        } catch (IllegalArgumentException | IOException | ParseException e) {
          getFileSelectionPan.setHint(e.getMessage());
        }
      }

    });


    actionMap.put("portfolioPerformance", () -> {
      getPortPerPanel = new PortfolioPerformancePanel();
      HelperClass.disposeTheSecondSetFirstView(getPortPerPanel,
          getAllOptions, this);
    });

    actionMap.put("homePPPanel", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions, getPortPerPanel, this);
    });


    actionMap.put("getPortPerformance", () -> {
      boolean check = HelperClass.checkPortPerformance(getPortPerPanel);
      if (check) {
        int portfolioId = Integer.valueOf(getPortPerPanel.getInput().get(0));
        String startDate = getPortPerPanel.getInput().get(1);
        String endDate = getPortPerPanel.getInput().get(2);
        String message = "";
        try {
          HashMap<LocalDate, Integer> map = newModel.portfolioPerformance(userId, userName,
              userEmail, portfolioId, startDate, endDate);
          if (map.size() == 1) {
            message = "No data is available";
          }
          DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          map.remove(LocalDate.parse("1800-01-01", dateTimeFormatter));
          frame = new JFrame();
          frame.setSize(900, 950);
          String t = "Performance of portfolio " + portfolioId
              + " from " + startDate + " to " + endDate;
          frame.getContentPane().add(new BarGraphImpl(map, t));

          WindowListener winListener = new WindowAdapter() {
            public void windowClosing(WindowEvent event) {

              System.exit(0);
            }
          };


          frame.addWindowListener(winListener);
          ppVar = new PortfolioPerformanceAll();
          frame.add((Component) ppVar, BorderLayout.PAGE_END);
          ppVar.addActionListener(this);
          frame.setVisible(true);

        } catch (Exception e) {
          message = e.getMessage();
        }
        getPortPerPanel.clearField();
        getPortPerPanel.errorMessage(message);
      } else {
        getPortPerPanel.clearField();
      }

    });


    actionMap.put("homePPB", () -> {
      getAllOptions = new FlexibleAllOptions();
      HelperClass.disposeTheSecondGetFirstBT(getAllOptions,
          getPortPerPanel, this);
      // helperClass.disposeBarGraph();
      frame.dispose();
    });


    actionMap.put("home", () -> {
      getAllOptions = new FlexibleAllOptions();
      getAllOptions.addActionListener(this);
    });


    actionMap.put("exit", () -> {
      System.exit(0);
    });


    return actionMap;
  }


  @Override
  public void actionPerformed(ActionEvent e) {

    this.str = e.getActionCommand();
    actionMap.get(str).run();
  }

}


